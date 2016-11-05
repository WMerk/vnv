package edeka.sw.emma.tomcatconfigurator.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edeka.sw.emma.tomcatconfigurator.model.konfiguration.KonfigurationDO;
import edeka.sw.emma.tomcatconfigurator.model.server.ServerDO;
import edeka.sw.emma.tomcatconfigurator.model.server.ServerlandschaftDO;
import edeka.sw.emma.tomcatconfigurator.model.server.SerververbundDO;
import edeka.sw.emma.tomcatconfigurator.rest.model.ServerlandschaftResponseDO;
import edeka.sw.emma.tomcatconfigurator.rest.service.konfigurationsverwaltung.KonfigurationService;
import edeka.sw.emma.tomcatconfigurator.rest.service.serververwaltung.ServerService;
import edeka.sw.emma.tomcatconfigurator.rest.service.serververwaltung.ServerlandschaftService;
import edeka.sw.emma.tomcatconfigurator.rest.service.serververwaltung.SerververbundService;
import edeka.sw.emma.tomcatconfigurator.rest.service.verschluesselung.VerschluesselungService;
import edeka.sw.emma.tomcatconfigurator.rest.service.xml.XMLMarshallerService;
import edeka.sw.emma.tomcatconfigurator.rest.service.xml.XMLTransportService;

/**
 * REST-Service zur Verwaltung der Server ({@link ServerlandschaftDO}, {@link SerververbundDO}
 * und {@link ServerDO}).
 * 
 * @author patrick.treyer
 * 
 */
@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
@Named
public class RestServiceServerVerw {

	private static final String FEHLER_BEIM_TRANSPORT_DER_XML_DOKUMENTE = "Fehler beim Transport der XML-Dokumente.";
	private static final String REVISION_VERBUND = "Verbund" + "|" + 1;

	private static final Logger logger = LoggerFactory
			.getLogger(RestServiceServerVerw.class);

	@Inject
	private KonfigurationService konfigurationService;
	@Inject
	private ServerlandschaftService serverlandschaftService;
	@Inject
	private SerververbundService serververbundService;
	@Inject
	private ServerService serverService;
	@Inject
	private VerschluesselungService verschluesselungService;
	@Inject
	private XMLMarshallerService xmlMarshallerService;
	@Inject
	private XMLTransportService xmlTransportService;

	/** Liest die Serverlandschaften aus der Datenbank aus und gibt diese zurueck.
	 * 
	 * @return die Liste der ausgelesenenen {@link ServerlandschaftDO}.
	 */
	@GET
	public Response readServerlandschaften() {
		ServerlandschaftResponseDO serverlanschResponse = new ServerlandschaftResponseDO();
		try {
			serverlanschResponse.setElements(serverlandschaftService.findAllServerlandschaften());
		} catch (SystemException e) {
			logger.error("Fehler beim Auslesen der Serverlandschaften. {}" , e.getMessage());
		}
		return Response.ok(serverlanschResponse).build();
	}

	/** Erzeugt eine neue {@link ServerlandschaftDO} anhand der uebergebenen Daten.
	 * 
	 * @param serverlandschaft, die zu erzeugende {@link ServerlandschaftDO}.
	 * @return die aktuelle Liste der {@link ServerlandschaftDO}.
	 * @throws IOException
	 */
	@POST
	@Path("/createServerlandschaft")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createServerlandschaften(ServerlandschaftDO serverlandschaft)
			throws IOException {
		ServerlandschaftResponseDO serverlanschResponse = new ServerlandschaftResponseDO();
		try {
			serverlandschaftService.createServerlandschaft(serverlandschaft);

			serverlanschResponse.setElements(serverlandschaftService
					.findAllServerlandschaften());
		} catch (SystemException e) {
			logger.error("Fehler beim Speichern der Serverlandschaft. {}" , e.getMessage());
		}
		return Response.ok(serverlanschResponse).build();
	}

	/** Erzeugt einen neuen {@link SerververbundDO} anhand der uebergebenen Daten.
	 * 
	 * @param serververbund, der zu erzeugende {@link SerververbundDO}.
	 * @return die aktuelle Liste der {@link ServerlandschaftDO}.
	 * @throws IOException
	 */
	@POST
	@Path("/createSerververbund")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createSerververbund(SerververbundDO serververbund)
			throws IOException {
		ServerlandschaftResponseDO serverlanschResponse = new ServerlandschaftResponseDO();
		try {
			ServerlandschaftDO serverlandschaft = serverlandschaftService
					.findServerlandschaftById(serververbund
							.getServerlandschaftId());

			if (serverlandschaft == null) {
				serverlanschResponse.setElements(serverlandschaftService
						.findAllServerlandschaften());
				return Response.ok(serverlanschResponse).build();
			}
			KonfigurationDO konfiguration = new KonfigurationDO();
			konfiguration.setRevision("Verbund|0");
			serververbund.setKonfiguration(konfigurationService
					.createKonfiguration(konfiguration));
			serververbund.setServer(new ArrayList<ServerDO>());
			serverlandschaft.getSerververbuende().add(
					serververbundService.createSerververbund(serververbund));
			serverlandschaftService.updateServerlandschaft(serverlandschaft);

			serverlanschResponse.setElements(serverlandschaftService
					.findAllServerlandschaften());

		} catch (SystemException e) {
			logger.error("Fehler beim Speichern des Serververbunds. {}" , e.getMessage());
		}
		return Response.ok(serverlanschResponse).build();
	}

	/** Erzeugt einen neuen {@link ServerDO} anhand der uebergebenen Daten.
	 * 
	 * @param server, der zu erzeugende {@link ServerDO}.
	 * @return die aktuelle Liste der {@link ServerDO}.
	 * @throws IOException
	 */
	@POST
	@Path("/createServer")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createServer(ServerDO server) throws IOException {
		SerververbundDO serververbund = null;
		try {
			serververbund = serververbundService.findSerververbundById(server
					.getSerververbundId());

			if (serververbund == null) {
				return null;
			}
			KonfigurationDO konfiguration = new KonfigurationDO();
			konfiguration.setRevision("Server|0");
			server.setKonfiguration(konfigurationService
					.createKonfiguration(konfiguration));
			
			server = verschluesselungService.verschluessleServer(server);

			serververbund.getServer().add(serverService.createServer(server));
			serververbund = serververbundService
					.updateSerververbund(serververbund);

		} catch (SystemException e) {
			logger.error("Fehler beim Speichern des Servers. {}" , e.getMessage());
		}
		return Response.ok(serververbund).build();
	}

	/** Aktualisiert eine {@link ServerlandschaftDO} anhand der uebergebenen Daten.
	 * 
	 * @param id, die Id der {@link ServerlandschaftDO}.
	 * @param name, der Name der {@link ServerlandschaftDO}.
	 */
	@POST
	@Path("/updateServerlandschaft")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public void updateServerlandschaften(@FormParam("id") Long id,
			@FormParam("name") String name) {
		try {
			ServerlandschaftDO serverlandschaft = serverlandschaftService.findServerlandschaftById(id);

			if (serverlandschaft == null) {
				return;
			}
			serverlandschaft.setName(name);

			serverlandschaftService.updateServerlandschaft(serverlandschaft);
		} catch (SystemException e) {
			logger.error("Fehler beim Aktualisieren der Serverlandschaft. {}" , e.getMessage());
		}
	}

	/** Aktualisiert einen {@link SerververbundDO} anhand der uebergebenen Daten.
	 * 
	 * @param id, die Id des {@link SerververbundDO}.
	 * @param verbundname, der Name des {@link SerververbundDO}.
	 * @param beschreibung, die Beschreibung des {@link SerververbundDO}.
	 */
	@POST
	@Path("/updateSerververbund")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public void updateSerververbund(@FormParam("id") Long id,
			@FormParam("verbundname") String verbundname,
			@FormParam("beschreibung") String beschreibung) {
		try {
			SerververbundDO serververbund = serververbundService
					.findSerververbundById(id);

			if (serververbund == null) {
				return;
			}
			serververbund.setVerbundname(verbundname);
			serververbund.setBeschreibung(beschreibung);

			serververbundService.updateSerververbund(serververbund);
		} catch (SystemException e) {
			logger.error("Fehler beim Aktualisieren des Serververbunds. {}" , e.getMessage());
		}
	}

	/** Aktualisiert einen {@link ServerDO} anhand der uebergebenen Daten.
	 * 
	 * @param id, die Id des {@link ServerDO}.
	 * @param servername, der Name des {@link ServerDO}.
	 * @param port, der Port des {@link ServerDO}.
	 * @param verzeichnis, das Verzeichnis des {@link ServerDO}.
	 * @param username, der Username des {@link ServerDO}.
	 * @param passwort, das Passwort des {@link ServerDO}.
	 */
	@POST
	@Path("/updateServer")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public void updateServer(@FormParam("id") Long id,
			@FormParam("servername") String servername,
			@FormParam("port") Integer port,
			@FormParam("verzeichnis") String verzeichnis,
			@FormParam("username") String username,
			@FormParam("passwort") String passwort) {

		try {
			ServerDO server = serverService.findServerById(id);

			if (server == null) {
				return;
			}
			server.setServername(servername);
			server.setPort(port);
			server.setVerzeichnis(verzeichnis);
			server.setUsername(username);
			server.setPasswort(passwort);

			server = verschluesselungService.verschluessleServer(server);

			serverService.updateServer(server);
		} catch (SystemException e) {
			logger.error("Fehler beim Aktualisieren des Servers. {}" , e.getMessage());
		}
	}

	/** Loescht eine {@link ServerlandschaftDO} aus der Datenbank.
	 * 
	 * @param id, die Id der zu loeschenden {@link ServerlandschaftDO}.
	 * @return die aktuelle Liste der {@link ServerlandschaftDO}.
	 */
	@DELETE
	@Path("/deleteServerlandschaft/{id}")
	public Response deleteServerlandschaften(@PathParam("id") Long id) {
		ServerlandschaftResponseDO serverlanschResponse = new ServerlandschaftResponseDO();
		try {
			ServerlandschaftDO serverlandschaft = new ServerlandschaftDO();
			serverlandschaft.setId(id);

			serverlandschaftService.deleteServerlandschaft(serverlandschaft);

			serverlanschResponse.setElements(serverlandschaftService.findAllServerlandschaften());
		} catch (SystemException e) {
			logger.error("Fehler beim Loeschen und Neuladen der Serverlandschaft. {}" , e.getMessage());
		}
		return Response.ok(serverlanschResponse).build();
	}

	/** Loescht einen {@link SerververbundDO} aus der Datenbank.
	 * 
	 * @param landschaftId, die Id der {@link ServerlandschaftDO}, 
	 *        in welcher der {@link SerververbundDO} vorhanden ist.
	 * @param id, die Id des zu loeschenden {@link SerververbundDO}.
	 * @return die aktuelle Liste der {@link ServerlandschaftDO}.
	 */
	@DELETE
	@Path("/deleteSerververbund/{landschaftId}/{id}")
	public Response deleteSerververbund(
			@PathParam("landschaftId") Long landschaftId,
			@PathParam("id") Long id) {
		ServerlandschaftResponseDO serverlanschResponse = new ServerlandschaftResponseDO();
		try {
			SerververbundDO serververbund = serververbundService.findSerververbundById(id);
			ServerlandschaftDO serverlandschaft = serverlandschaftService.findServerlandschaftById(landschaftId);

			if (serververbund == null || serverlandschaft == null) {
				serverlanschResponse.setElements(serverlandschaftService.findAllServerlandschaften());
				return Response.ok(serverlanschResponse).build();
			}

			SerververbundDO found = null;
			for (SerververbundDO serververbundDO : serverlandschaft.getSerververbuende()) {
				if (serververbundDO.getId().equals(serververbund.getId())) {
					found = serververbundDO;
				}
			}
			if (found != null) {
				serverlandschaft.getSerververbuende().remove(found);
				serverlandschaftService.updateServerlandschaft(serverlandschaft);
			}

			serverlanschResponse.setElements(serverlandschaftService.findAllServerlandschaften());
		} catch (SystemException e) {
			logger.error("Fehler beim Loeschen und Neuladen des Serververbunds. {}" , e.getMessage());
		}
		return Response.ok(serverlanschResponse).build();
	}

	/** Loescht einen {@link ServerDO} aus der Datenbank.
	 * 
	 * @param verbundId, die Id des {@link SerververbundDO}, 
	 *        in welcher der {@link ServerDO} vorhanden ist.
	 * @param id, die Id des zu loeschenden {@link ServerDO}.
	 * @return die aktuelle Liste der {@link ServerlandschaftDO}.
	 */
	@DELETE
	@Path("/deleteServer/{verbundId}/{id}")
	public Response deleteServer(@PathParam("verbundId") Long verbundId,
			@PathParam("id") Long id) {

		SerververbundDO serververbund = null;
		ServerDO server = null;
		try {
			serververbund = serververbundService.findSerververbundById(verbundId);
			server = serverService.findServerById(id);

			if (server == null || serververbund == null) {
				return Response.ok(serververbund).build();
			}

			ServerDO found = null;
			for (ServerDO serverDO : serververbund.getServer()) {
				if (serverDO.getId().equals(server.getId())) {
					found = serverDO;
				}
			}
			if (found != null) {
				serververbund.getServer().remove(found);
				serververbund = serververbundService
						.updateSerververbund(serververbund);
				serverService.deleteServer(server);
			}
		} catch (SystemException e) {
			logger.error("Fehler beim Loeschen und Neuladen des Servers. {}" , e.getMessage());
		}
		return Response.ok(serververbund).build();
	}

	/** Erzeugt die XML-Dokumente fuer die {@link KonfigurationDO} eines {@link SerververbundDO} 
	 * und gibt diese zurueck.
	 * 
	 * @param id, die Id des {@link SerververbundDO}.
	 * @return der {@link InputStream} der gezippten XML-Konfigurationsdokumente.
	 */
	@GET
	@Path("/createXMLSerververbund/{id}")
	public Response createXMLSerververbund(@PathParam("id") Long id) {
		try {
			SerververbundDO serververbund = serververbundService.findSerververbundById(id);

			if (serververbund == null) {
				return Response.ok(Boolean.FALSE).build();
			}
			KonfigurationDO konfiguration = serververbund.getKonfiguration();
			if (konfiguration == null) {
				return Response.ok(Boolean.FALSE).build();
			}
			return Response.ok(xmlMarshallerService.generateXMLArchive(konfiguration)).build();
		} catch (SystemException e) {
			logger.error("Fehler beim Generieren der XML-Dokumente. {}" , e.getMessage());
		}
		return null;
	}

	/** Erzeugt die XML-Dokumente fuer die {@link KonfigurationDO} eines {@link ServerDO} 
	 * und gibt diese zurueck.
	 * 
	 * @param id, die Id des {@link SerververbundDO}.
	 * @return der {@link InputStream} der gezippten XML-Konfigurationsdokumente.
	 */
	@GET
	@Path("/createXMLServer/{id}")
	public Response createXMLServer(@PathParam("id") Long id) {
		try {
			ServerDO server = serverService.findServerById(id);

			if (server == null) {
				return Response.ok(Boolean.FALSE).build();
			}
			KonfigurationDO konfiguration = server.getKonfiguration();
			if (konfiguration == null) {
				return Response.ok(Boolean.FALSE).build();
			}
			
			return Response.ok(xmlMarshallerService.generateXMLArchive(konfiguration)).build();
		} catch (SystemException e) {
			logger.error("Fehler beim Generieren der XML-Dokumente. {}" , e.getMessage());
		}
		return null;
	}

	/** Transportiert die XML-Konfigurationen eines einzelnen {@link ServerDO}, auf genau diesen.
	 * 	Anschließend wird die Revision gesetzt.
	 * 
	 * @param id, die Id des {@link ServerDO}.
	 * @param verbundId, die id des {@link SerververbundDO}, 
	 * 		  in welchem der {@link ServerDO} enthalten ist.
	 * @return der aktalisierte {@link SerververbundDO}.
	 */
	@GET
	@Path("/transportFilesServer/{id}/{verbundId}")
	public Response transportFilesServer(@PathParam("id") Long id, @PathParam("verbundId") Long verbundId) {
		try {
			ServerDO server = serverService.findServerById(id);

			if (server == null) {
				return null;
			}
			KonfigurationDO konfiguration = server.getKonfiguration();
			if (konfiguration == null) {
				return null;
			}

			boolean result = xmlTransportService.transportFilesServer(server, server.getKonfiguration());
			if(!result){
				return Response.ok(serververbundService.findSerververbundById(verbundId)).build();
			}
			
			ServerDO updatedServer = xmlTransportService.generateRevisionServer(server);
			konfigurationService.updateKonfiguration(updatedServer.getKonfiguration());
			
			return Response.ok(serververbundService.findSerververbundById(verbundId)).build();
		} catch (SystemException e) {
			logger.error(FEHLER_BEIM_TRANSPORT_DER_XML_DOKUMENTE);
		}
		return null;
	}

	/** Transportiert die XML-Konfigurationen eines gesamten {@link SerververbundDO} auf alle {@link ServerDO} in diesem.
	 * 	Anschließend wird die Revision gesetzt.
	 * 
	 * @param id, die Id des {@link SerververbundDO}.
	 * @return der aktalisierte {@link SerververbundDO}.
	 */
	@GET
	@Path("/transportFilesSerververbund/{id}")
	public Response transportFilesSerververbund(@PathParam("id") Long id) {
		try {
			SerververbundDO serververbund = serververbundService.findSerververbundById(id);

			if (serververbund == null) {
				return null;
			}
			KonfigurationDO konfiguration = serververbund.getKonfiguration();
			if (konfiguration == null) {
				return null;
			}

			boolean result = xmlTransportService.transportFilesSerververbund(serververbund);
			if(result){
				konfiguration.setRevision(REVISION_VERBUND);
				konfigurationService.updateKonfiguration(konfiguration);
				
				for (ServerDO server : serververbund.getServer()) {
					ServerDO updatedServer = xmlTransportService.generateRevisionSerververbund(
							serververbund, server);
					konfigurationService.updateKonfiguration(updatedServer.getKonfiguration());
				}
			}
			
			return Response.ok(serververbundService.findSerververbundById(id)).build();
		} catch (SystemException e) {
			logger.error(FEHLER_BEIM_TRANSPORT_DER_XML_DOKUMENTE);
		}
		return null;
	}

}
