package edeka.sw.emma.tomcatconfigurator.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edeka.sw.emma.tomcatconfigurator.model.server.ServerlandschaftDO;

/**
 * Dieses Objekt dient zur Uebergabe der Serverlandschaften ueber die
 * REST-Schnittstelle.
 * 
 * @author patrick.treyer
 * 
 */
@XmlRootElement(name = "serverlandschaften")
public class ServerlandschaftResponseDO {

	public ServerlandschaftResponseDO() {
	}

	public ServerlandschaftResponseDO(
			List<ServerlandschaftDO> serverlandschaften) {
		this.serverlandschaften = serverlandschaften;
	}

	private List<ServerlandschaftDO> serverlandschaften;

	@XmlElement(name = "serverlandschaften")
	public List<ServerlandschaftDO> getElements() {
		return serverlandschaften;
	}

	public void setElements(List<ServerlandschaftDO> serverlandschaften) {
		this.serverlandschaften = serverlandschaften;
	}

}
