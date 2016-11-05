package edeka.sw.emma.tomcatconfigurator.rest.service.verschluesselung;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.inject.Named;
import javax.transaction.SystemException;

import edeka.sw.config.resourcesecurity.EncryptionException;
import edeka.sw.config.resourcesecurity.Encryptor;
import edeka.sw.emma.tomcatconfigurator.model.konfiguration.typen.AttributDO;
import edeka.sw.emma.tomcatconfigurator.model.konfiguration.typen.JDBCKonfigDO;
import edeka.sw.emma.tomcatconfigurator.model.konfiguration.typen.MailRessourcenKonfigDO;
import edeka.sw.emma.tomcatconfigurator.model.konfiguration.typen.WorkmanagerKonfigDO;
import edeka.sw.emma.tomcatconfigurator.model.konfiguration.typen.ZentralKonfigDO;
import edeka.sw.emma.tomcatconfigurator.model.server.ServerDO;

/** Service zur Verschluesselung sicherheitskritischer Daten.
 * 
 * @author patrick.treyer
 *
 */
@Named
public class VerschluesselungService {

	private static final String ENCRYPTED_PREFIX = "ENCRYPTED|";

	/** Entschluesselt ein bestimmtes Attribut.
	 * 
	 * @param attribute, das zu entschluesselnde Attribut.
	 * @return das entschluesselte Attribut.
	 * @throws SystemException
	 */
	public String entschlüssleAttribute(String attribute)
			throws SystemException {
		try {
			Encryptor encryptor = new Encryptor(null);

			if (isEncrypted(attribute)) {
				return encryptor.decrypt(attribute);
			}

		} catch (EncryptionException e) {
			throw new SystemException(e.getMessage());
		}
		return attribute;
	}

	/** Verschluesselt die sicherheitskritischen Daten eines {@link ServerDO}.
	 * 
	 * @param server, der zu verschluesselnde {@link ServerDO}.
	 * @return der verschluesselte {@link ServerDO}.
	 * @throws SystemException
	 */
	public ServerDO verschluessleServer(ServerDO server) throws SystemException {
		ServerDO enryptedServer = server;
		try {
			Encryptor encryptor = new Encryptor(null);

			if (!isEncrypted(enryptedServer.getPasswort())) {
				enryptedServer.setPasswort(ENCRYPTED_PREFIX
						+ encryptor.encrypt(enryptedServer.getPasswort()));
			}

		} catch (EncryptionException e) {
			throw new SystemException(e.getMessage());
		} catch (InvalidKeyException e) {
			throw new SystemException(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new SystemException(e.getMessage());
		} catch (NoSuchPaddingException e) {
			throw new SystemException(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			throw new SystemException(e.getMessage());
		} catch (BadPaddingException e) {
			throw new SystemException(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new SystemException(e.getMessage());
		}
		return enryptedServer;
	}

	/** Verschluesselt eine {@link ZentralKonfigDO}.
	 * 
	 * @param zentralKonfig, die zu verschluesselnde {@link ZentralKonfigDO}.
	 * @return die verschluesselte {@link ZentralKonfigDO}.
	 * @throws SystemException
	 */
	public ZentralKonfigDO verschluessleZentralkonfiguration(
			ZentralKonfigDO zentralKonfig) throws SystemException {
		ZentralKonfigDO encryptedZentralKonfig = zentralKonfig;
		try {
			Encryptor encryptor = new Encryptor(null);

			for (AttributDO attribut : encryptedZentralKonfig.getAttributes()) {
				if (attribut.isVerschluesselung()) {
					if (!isEncrypted(attribut.getValue())) {
						attribut.setValue(ENCRYPTED_PREFIX
								+ encryptor.encrypt(attribut.getValue()));
					}
				}
			}
		} catch (EncryptionException e) {
			throw new SystemException(e.getMessage());
		} catch (InvalidKeyException e) {
			throw new SystemException(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new SystemException(e.getMessage());
		} catch (NoSuchPaddingException e) {
			throw new SystemException(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			throw new SystemException(e.getMessage());
		} catch (BadPaddingException e) {
			throw new SystemException(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new SystemException(e.getMessage());
		}
		return encryptedZentralKonfig;
	}

	/** Verschluesselt eine {@link JDBCKonfigDO}.
	 * 
	 * @param jdbcKonfig, die zu verschluesselnde {@link JDBCKonfigDO}.
	 * @return die verschluesselte {@link JDBCKonfigDO}.
	 * @throws SystemException
	 */
	public JDBCKonfigDO verschluessleJDBCKonfiguration(JDBCKonfigDO jdbcKonfig)
			throws SystemException {
		JDBCKonfigDO encryptedJDBCKonfig = jdbcKonfig;
		try {
			Encryptor encryptor = new Encryptor(null);

			if (!isEncrypted(encryptedJDBCKonfig.getPasswort())) {
				encryptedJDBCKonfig.setPasswort(ENCRYPTED_PREFIX
						+ encryptor.encrypt(encryptedJDBCKonfig.getPasswort()));
			}

			for (AttributDO attribut : encryptedJDBCKonfig.getAttributes()) {
				if (attribut.isVerschluesselung()) {
					if (!isEncrypted(attribut.getValue())) {
						attribut.setValue(ENCRYPTED_PREFIX
								+ encryptor.encrypt(attribut.getValue()));
					}
				}
			}
		} catch (EncryptionException e) {
			throw new SystemException(e.getMessage());
		} catch (InvalidKeyException e) {
			throw new SystemException(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new SystemException(e.getMessage());
		} catch (NoSuchPaddingException e) {
			throw new SystemException(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			throw new SystemException(e.getMessage());
		} catch (BadPaddingException e) {
			throw new SystemException(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new SystemException(e.getMessage());
		}
		return encryptedJDBCKonfig;
	}

	/** Verschluesselt eine {@link MailRessourcenKonfigDO}.
	 * 
	 * @param mailRessourcenKonfig, die zu verschluesselnde {@link MailRessourcenKonfigDO}.
	 * @return die verschluesselte {@link MailRessourcenKonfigDO}.
	 * @throws SystemException
	 */
	public MailRessourcenKonfigDO verschluessleMailressource(
			MailRessourcenKonfigDO mailRessourcenKonfig) throws SystemException {
		MailRessourcenKonfigDO encryptedMailressource = mailRessourcenKonfig;
		try {
			Encryptor encryptor = new Encryptor(null);

			for (AttributDO attribut : encryptedMailressource.getAttributes()) {
				if (attribut.isVerschluesselung()) {
					if (!isEncrypted(attribut.getValue())) {
						attribut.setValue(ENCRYPTED_PREFIX
								+ encryptor.encrypt(attribut.getValue()));
					}
				}
			}
		} catch (EncryptionException e) {
			throw new SystemException(e.getMessage());
		} catch (InvalidKeyException e) {
			throw new SystemException(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new SystemException(e.getMessage());
		} catch (NoSuchPaddingException e) {
			throw new SystemException(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			throw new SystemException(e.getMessage());
		} catch (BadPaddingException e) {
			throw new SystemException(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new SystemException(e.getMessage());
		}
		return encryptedMailressource;
	}

	/** Verschluesselt eine {@link WorkmanagerKonfigDO}.
	 * 
	 * @param workmanagerKonfig, die zu verschluesselnde {@link WorkmanagerKonfigDO}.
	 * @return die verschluesselte {@link WorkmanagerKonfigDO}.
	 * @throws SystemException
	 */
	public WorkmanagerKonfigDO verschluessleWorkmanager(
			WorkmanagerKonfigDO workmanagerKonfig) throws SystemException {
		WorkmanagerKonfigDO encryptedWorkmanagerKonfig = workmanagerKonfig;
		try {
			Encryptor encryptor = new Encryptor(null);

			for (AttributDO attribut : encryptedWorkmanagerKonfig
					.getAttributes()) {
				if (attribut.isVerschluesselung()) {
					if (!isEncrypted(attribut.getValue())) {
						attribut.setValue(ENCRYPTED_PREFIX
								+ encryptor.encrypt(attribut.getValue()));
					}
				}
			}
		} catch (EncryptionException e) {
			throw new SystemException(e.getMessage());
		} catch (InvalidKeyException e) {
			throw new SystemException(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new SystemException(e.getMessage());
		} catch (NoSuchPaddingException e) {
			throw new SystemException(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			throw new SystemException(e.getMessage());
		} catch (BadPaddingException e) {
			throw new SystemException(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new SystemException(e.getMessage());
		}
		return encryptedWorkmanagerKonfig;
	}

	/** Prueft ob ein String bereits verschluesselt ist oder nicht.
	 * 
	 * @param value, der zu ueberpruefende String.
	 * @return true/false, je nachdem ob eine Verschluesselung vorhanden ist oder nicht.
	 */
	private boolean isEncrypted(String value) {
		if (value.startsWith(ENCRYPTED_PREFIX)) {
			return true;
		}
		return false;
	}

}
