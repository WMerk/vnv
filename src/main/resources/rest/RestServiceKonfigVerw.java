package edeka.sw.emma.tomcatconfigurator.rest;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edeka.sw.emma.tomcatconfigurator.model.konfiguration.KonfigurationDO;
import edeka.sw.emma.tomcatconfigurator.model.konfiguration.typen.JDBCKonfigDO;
import edeka.sw.emma.tomcatconfigurator.model.konfiguration.typen.MailRessourcenKonfigDO;
import edeka.sw.emma.tomcatconfigurator.model.konfiguration.typen.WorkmanagerKonfigDO;
import edeka.sw.emma.tomcatconfigurator.model.konfiguration.typen.ZentralKonfigDO;
import edeka.sw.emma.tomcatconfigurator.rest.service.konfigurationsverwaltung.JDBCKonfigurationService;
import edeka.sw.emma.tomcatconfigurator.rest.service.konfigurationsverwaltung.KonfigurationService;
import edeka.sw.emma.tomcatconfigurator.rest.service.konfigurationsverwaltung.MailRessourcenService;
import edeka.sw.emma.tomcatconfigurator.rest.service.konfigurationsverwaltung.WorkmanagerService;
import edeka.sw.emma.tomcatconfigurator.rest.service.konfigurationsverwaltung.ZentralkonfigurationService;
import edeka.sw.emma.tomcatconfigurator.rest.service.verschluesselung.VerschluesselungService;

/**
 * REST-Service zur Verwaltung der Konfigurationen ({@link JDBCKonfigDO}, 
 * {@link ZentralKonfigDO}, {@link JDBCKonfigDO}, {@link MailRessourcenKonfigDO}, 
 * {@link KonfigurationDO})
 * 
 * @author patrick.treyer
 * 
 */
@Path("/konfiguration")
@Produces(MediaType.APPLICATION_JSON)
@Named
public class RestServiceKonfigVerw {

	private static final Logger logger = LoggerFactory
			.getLogger(RestServiceKonfigVerw.class);

	@Inject
	private KonfigurationService konfigurationService;
	@Inject
	private JDBCKonfigurationService jdbcKonfigurationService;
	@Inject
	private ZentralkonfigurationService zentralkonfigurationService;
	@Inject
	private MailRessourcenService mailRessourcenService;
	@Inject
	private WorkmanagerService workmanagerService;
	@Inject
	private VerschluesselungService verschluesselungService;
	
	/** Erzeugt eine neue {@link ZentralKonfigDO} anhand der uebergebenen Daten.
	 * 
	 * @param zentralKonfig, die zu erzeugende {@link ZentralKonfigDO}.
	 * @return die {@link KonfigurationDO}, in welcher die {@link ZentralKonfigDO} erzeugt wurde.
	 * @throws IOException
	 */
	@POST
	@Path("/createZentralkonfiguration")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createZentralKonfiguration(ZentralKonfigDO zentralKonfig)
			throws IOException {
		
		ZentralKonfigDO zentralKonfiguration = zentralKonfig;
		KonfigurationDO konfiguration = null;
		try {
			konfiguration = konfigurationService.findKonfigurationById(zentralKonfiguration.getKonfigurationId());

			if (konfiguration == null) {
				return null;
			}
			if (konfiguration.getZentralKonfigurationen() == null) {
				konfiguration.setZentralKonfigurationen(new ArrayList<ZentralKonfigDO>());
				konfigurationService.updateKonfiguration(konfiguration);
			}
			zentralKonfiguration = verschluesselungService.verschluessleZentralkonfiguration(zentralKonfiguration);
			
			konfiguration.getZentralKonfigurationen().add(zentralkonfigurationService
							.createZentralKonfiguration(zentralKonfiguration));
			
			konfiguration = konfigurationService.updateKonfiguration(konfiguration);
		} catch (SystemException e) {
			logger.error("Fehler beim Speichern der Zentralkonfiguration. {}" , e.getMessage());
		}
		return Response.ok(konfiguration).build();
	}

	/** Erzeugt eine neue {@link JDBCKonfigDO} anhand der uebergebenen Daten.
	 * 
	 * @param jdbcKonfig, die zu erzeugende {@link JDBCKonfigDO}.
	 * @return die {@link KonfigurationDO}, in welcher die {@link JDBCKonfigDO} erzeugt wurde.
	 * @throws IOException
	 */
	@POST
	@Path("/createJDBCKonfiguration")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createJDBCKonfiguration(JDBCKonfigDO jdbcKonfig)
			throws IOException {
		JDBCKonfigDO jdbcKonfiguration = jdbcKonfig;
		KonfigurationDO konfiguration = null;
		try {
			konfiguration = konfigurationService.findKonfigurationById(jdbcKonfiguration
							.getKonfigurationId());

			if (konfiguration == null) {
				return null;
			}
			if (konfiguration.getJdbcKonfigurationen() == null) {
				konfiguration.setJdbcKonfigurationen(new ArrayList<JDBCKonfigDO>());
				konfigurationService.updateKonfiguration(konfiguration);
			}
			jdbcKonfiguration = verschluesselungService.verschluessleJDBCKonfiguration(jdbcKonfiguration);
			
			konfiguration.getJdbcKonfigurationen().add(jdbcKonfigurationService.
					createJDBCKonfiguration(jdbcKonfiguration));
			konfiguration = konfigurationService.updateKonfiguration(konfiguration);
		} catch (SystemException e) {
			logger.error("Fehler beim Speichern der JDBC-Konfiguration. {}" , e.getMessage());
		}
		return Response.ok(konfiguration).build();
	}

	/** Erzeugt eine neue {@link MailRessourcenKonfigDO} anhand der uebergebenen Daten.
	 * 
	 * @param mailRessourcenKonfig, die zu erzeugende {@link MailRessourcenKonfigDO}.
	 * @return die {@link KonfigurationDO}, in welcher die {@link MailRessourcenKonfigDO} erzeugt wurde.
	 * @throws IOException
	 */
	@POST
	@Path("/createMailRessKonfiguration")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createMailRessKonfiguration(
			MailRessourcenKonfigDO mailRessourcenKonfig) throws IOException {
		MailRessourcenKonfigDO mailRessource = mailRessourcenKonfig;
		KonfigurationDO konfiguration = null;
		try {
			konfiguration = konfigurationService.findKonfigurationById(mailRessource
							.getKonfigurationId());

			if (konfiguration == null) {
				return null;
			}
			if (konfiguration.getMailRessKonfigurationen() == null) {
				konfiguration
						.setMailRessKonfigurationen(new ArrayList<MailRessourcenKonfigDO>());
				konfigurationService.updateKonfiguration(konfiguration);
			}

			mailRessource = verschluesselungService.verschluessleMailressource(mailRessource);
			
			konfiguration.getMailRessKonfigurationen().add(mailRessourcenService
							.createMailRessourcenKonfiguration(mailRessource));
			konfiguration = konfigurationService.updateKonfiguration(konfiguration);
		} catch (SystemException e) {
			logger.error("Fehler beim Speichern der Mailressourcen-Konfiguration. {}" , e.getMessage());
		}
		return Response.ok(konfiguration).build();
	}

	/** Erzeugt eine neue {@link WorkmanagerKonfigDO} anhand der uebergebenen Daten.
	 * 
	 * @param workmanagerKonfig, die zu erzeugende {@link WorkmanagerKonfigDO}.
	 * @return die {@link KonfigurationDO}, in welcher die {@link WorkmanagerKonfigDO} erzeugt wurde.
	 * @throws IOException
	 */
	@POST
	@Path("/createWorkmanagerKonfiguration")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createWorkmanagerKonfiguration(
			WorkmanagerKonfigDO workmanagerKonfig) throws IOException {
		WorkmanagerKonfigDO workmanagerKonfiguration = workmanagerKonfig;
		KonfigurationDO konfiguration = null;
		try {
			konfiguration = konfigurationService.findKonfigurationById(workmanagerKonfiguration
							.getKonfigurationId());

			if (konfiguration == null) {
				return null;
			}
			if (konfiguration.getWorkmanagerKonfigurationen() == null) {
				konfiguration
						.setWorkmanagerKonfigurationen(new ArrayList<WorkmanagerKonfigDO>());
				konfigurationService.updateKonfiguration(konfiguration);
			}

			workmanagerKonfiguration = verschluesselungService.verschluessleWorkmanager(workmanagerKonfiguration);
			
			konfiguration.getWorkmanagerKonfigurationen().add(workmanagerService
							.createWorkmanagerKonfiguration(workmanagerKonfiguration));
			konfiguration = konfigurationService.updateKonfiguration(konfiguration);
		} catch (SystemException e) {
			logger.error("Fehler beim Speichern der Workmanager-Konfiguration. {}" , e.getMessage());
		}
		return Response.ok(konfiguration).build();
	}

	/** Loescht eine {@link ZentralKonfigDO} aus der Datenbank.
	 * 
	 * @param konfigurationId, die Id der {@link KonfigurationDO}, 
	 * 	      in welcher die {@link ZentralKonfigDO} enthalten ist.
	 * @param id, die Id der zu loeschenden {@link ZentralKonfigDO}.
	 * @return die {@link KonfigurationDO}, in welcher die {@link ZentralKonfigDO} erzeugt wurde. 
	 */
	@DELETE
	@Path("/deleteZentralKonfiguration/{konfigurationId}/{id}")
	public Response deleteZentralKonfiguration(
			@PathParam("konfigurationId") Long konfigurationId,
			@PathParam("id") Long id) {
		KonfigurationDO konfiguration = null;
		try {
			ZentralKonfigDO zentralKonfig = zentralkonfigurationService
					.findZentralKonfigurationById(id);

			konfiguration = konfigurationService
					.findKonfigurationById(konfigurationId);

			if (zentralKonfig == null || konfiguration == null) {
				return Response.ok(konfiguration).build();
			}

			ZentralKonfigDO found = null;
			for (ZentralKonfigDO zentralKonfigDO : konfiguration.getZentralKonfigurationen()) {
				if (zentralKonfig.getId().equals(zentralKonfigDO.getId())) {
					found = zentralKonfigDO;
				}
			}
			if (found != null) {
				konfiguration.getZentralKonfigurationen().remove(found);
				konfiguration = konfigurationService.updateKonfiguration(konfiguration);
				zentralkonfigurationService.deleteZentralKonfiguration(zentralKonfig);
			}
		} catch (SystemException e) {
			logger.error("Fehler beim Loeschen und Neuladen der Zentralkonfiguration. {}" , e.getMessage());
		}
		return Response.ok(konfiguration).build();
	}

	/** Loescht eine {@link JDBCKonfigDO} aus der Datenbank.
	 * 
	 * @param konfigurationId, die Id der {@link KonfigurationDO}, 
	 * 	      in welcher die {@link JDBCKonfigDO} enthalten ist.
	 * @param id, die Id der zu loeschenden {@link JDBCKonfigDO}.
	 * @return die {@link KonfigurationDO}, in welcher die {@link JDBCKonfigDO} erzeugt wurde. 
	 */
	@DELETE
	@Path("/deleteJDBCKonfiguration/{konfigurationId}/{id}")
	public Response deleteJDBCKonfiguration(
			@PathParam("konfigurationId") Long konfigurationId,
			@PathParam("id") Long id) {
		KonfigurationDO konfiguration = null;
		try {
			JDBCKonfigDO jdbcKonfig = jdbcKonfigurationService
					.findJDBCKonfigurationById(id);

			konfiguration = konfigurationService
					.findKonfigurationById(konfigurationId);

			if (jdbcKonfig == null || konfiguration == null) {
				return Response.ok(konfiguration).build();
			}

			JDBCKonfigDO found = null;
			for (JDBCKonfigDO jdbcKonfigDO : konfiguration.getJdbcKonfigurationen()) {
				if (jdbcKonfig.getId().equals(jdbcKonfigDO.getId())) {
					found = jdbcKonfigDO;
				}
			}
			if (found != null) {
				konfiguration.getJdbcKonfigurationen().remove(found);
				konfiguration = konfigurationService.updateKonfiguration(konfiguration);
				jdbcKonfigurationService.deleteJDBCKonfiguration(jdbcKonfig);
			}
		} catch (SystemException e) {
			logger.error("Fehler beim Loeschen und Neuladen der JDBC-Konfiguration. {}" , e.getMessage());
		}
		return Response.ok(konfiguration).build();
	}

	/** Loescht eine {@link MailRessourcenKonfigDO} aus der Datenbank.
	 * 
	 * @param konfigurationId, die Id der {@link KonfigurationDO}, 
	 * 	      in welcher die {@link MailRessourcenKonfigDO} enthalten ist.
	 * @param id, die Id der zu loeschenden {@link MailRessourcenKonfigDO}.
	 * @return die {@link KonfigurationDO}, in welcher die {@link MailRessourcenKonfigDO} erzeugt wurde. 
	 */
	@DELETE
	@Path("/deleteMailRessKonfiguration/{konfigurationId}/{id}")
	public Response deleteMailRessKonfiguration(
			@PathParam("konfigurationId") Long konfigurationId,
			@PathParam("id") Long id) {
		KonfigurationDO konfiguration = null;
		try {
			MailRessourcenKonfigDO mailRessourcenKonfig = mailRessourcenService
					.findMailRessourcenKonfigurationById(id);

			konfiguration = konfigurationService
					.findKonfigurationById(konfigurationId);

			if (mailRessourcenKonfig == null || konfiguration == null) {
				return Response.ok(konfiguration).build();
			}

			MailRessourcenKonfigDO found = null;
			for (MailRessourcenKonfigDO mailRessourcenKonfigDO : konfiguration.getMailRessKonfigurationen()) {
				if (mailRessourcenKonfigDO.getId().equals(mailRessourcenKonfig.getId())) {
					found = mailRessourcenKonfigDO;
				}
			}
			if (found != null) {
				konfiguration.getMailRessKonfigurationen().remove(found);
				konfiguration = konfigurationService.updateKonfiguration(konfiguration);
				mailRessourcenService.deleteMailRessourcenKonfiguration(mailRessourcenKonfig);
			}
		} catch (SystemException e) {
			logger.error("Fehler beim Loeschen und Neuladen der Mailressourcen-Konfiguration. {}" , e.getMessage());
		}
		return Response.ok(konfiguration).build();
	}

	/** Loescht eine {@link WorkmanagerKonfigDO} aus der Datenbank.
	 * 
	 * @param konfigurationId, die Id der {@link KonfigurationDO}, 
	 * 	      in welcher die {@link WorkmanagerKonfigDO} enthalten ist.
	 * @param id, die Id der zu loeschenden {@link WorkmanagerKonfigDO}.
	 * @return die {@link KonfigurationDO}, in welcher die {@link WorkmanagerKonfigDO} erzeugt wurde. 
	 */
	@DELETE
	@Path("/deleteWorkmanagerKonfiguration/{konfigurationId}/{id}")
	public Response deleteWorkmanagerKonfiguration(
			@PathParam("konfigurationId") Long konfigurationId,
			@PathParam("id") Long id) {
		KonfigurationDO konfiguration = null;
		try {
			WorkmanagerKonfigDO workmanagerKonfig = workmanagerService
					.findWorkmanagerKonfigurationById(id);

			konfiguration = konfigurationService.findKonfigurationById(konfigurationId);

			if (workmanagerKonfig == null || konfiguration == null) {
				return Response.ok(konfiguration).build();
			}

			WorkmanagerKonfigDO found = null;
			for (WorkmanagerKonfigDO workmanagerKonfigDO : konfiguration.getWorkmanagerKonfigurationen()) {
				if (workmanagerKonfigDO.getId().equals(	workmanagerKonfig.getId())) {
					found = workmanagerKonfigDO;
				}
			}
			if (found != null) {
				konfiguration.getWorkmanagerKonfigurationen().remove(found);
				konfiguration = konfigurationService.updateKonfiguration(konfiguration);
				workmanagerService.deleteWorkmanagerKonfiguration(workmanagerKonfig);
			}
		} catch (SystemException e) {
			logger.error("Fehler beim Loeschen und Neuladen der Workmanager-Konfiguration. {}" , e.getMessage());
		}
		return Response.ok(konfiguration).build();
	}

	/** Aktualisiert die ubergebene {@link ZentralKonfigDO} in der Datenbank.
	 * 
	 * @param zentralKonfig, die zu aktualisierende {@link ZentralKonfigDO}.
	 * @throws IOException
	 */
	@POST
	@Path("/updateZentralKonfiguration")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateZentralKonfiguration(ZentralKonfigDO zentralKonfig)
			throws IOException {
		ZentralKonfigDO zentralKonfiguration = zentralKonfig;
		try {
			zentralKonfiguration = verschluesselungService.verschluessleZentralkonfiguration(zentralKonfiguration);
			zentralkonfigurationService.updateZentralKonfiguration(zentralKonfiguration);
		} catch (SystemException e) {
			logger.error("Fehler beim Aktualisieren der Zentralkonfiguration. {}" , e.getMessage());
		}
	}

	/** Aktualisiert die ubergebene {@link JDBCKonfigDO} in der Datenbank.
	 * 
	 * @param jdbcKonfig, die zu aktualisierende {@link JDBCKonfigDO}.
	 * @throws IOException
	 */
	@POST
	@Path("/updateJDBCKonfiguration")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateJDBCKonfiguration(JDBCKonfigDO jdbcKonfig)
			throws IOException {
		JDBCKonfigDO jdbcKonfiguration = jdbcKonfig;
		try {
			jdbcKonfiguration = verschluesselungService.verschluessleJDBCKonfiguration(jdbcKonfiguration);
			jdbcKonfigurationService.updateJDBCKonfiguration(jdbcKonfiguration);
		} catch (SystemException e) {
			logger.error("Fehler beim Aktualisieren der JDBC-Konfiguration. {}" , e.getMessage());

		}
	}

	/** Aktualisiert die ubergebene {@link MailRessourcenKonfigDO} in der Datenbank.  
	 * 
	 * @param mailRessourcenKonfig, die zu aktualisierende {@link MailRessourcenKonfigDO}.
	 * @throws IOException
	 */
	@POST
	@Path("/updateMailRessKonfiguration")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateMailRessKonfiguration(
			MailRessourcenKonfigDO mailRessourcenKonfig) throws IOException {
		MailRessourcenKonfigDO mailRessource = mailRessourcenKonfig;
		try {
			mailRessource = verschluesselungService.verschluessleMailressource(mailRessource);
			mailRessourcenService.updateMailRessourcenKonfiguration(mailRessource);
		} catch (SystemException e) {
			logger.error("Fehler beim Aktualisieren der Mailressourcen-Konfiguration. {}" , e.getMessage());
		}
	}

	/** Aktualisiert die ubergebene {@link WorkmanagerKonfigDO} in der Datenbank.  
	 * 
	 * @param workmanagerKonfig, die zu aktualisierende {@link WorkmanagerKonfigDO}.
	 * @throws IOException
	 */
	@POST
	@Path("/updateWorkmanagerKonfiguration")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateWorkmanagerKonfiguration(
			WorkmanagerKonfigDO workmanagerKonfig) throws IOException {
		WorkmanagerKonfigDO workmanagerKonfiguration = workmanagerKonfig;
		try {
			workmanagerKonfiguration = verschluesselungService.verschluessleWorkmanager(workmanagerKonfiguration);
			workmanagerService.updateWorkmanagerKonfiguration(workmanagerKonfiguration);
		} catch (SystemException e) {
			logger.error("Fehler beim Aktualisieren der Workmanager-Konfiguration. {}" , e.getMessage());
		}
	}

}
