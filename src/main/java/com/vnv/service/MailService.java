package com.vnv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailService {

    private Logger log = LoggerFactory.getLogger(MailService.class);

        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage generateMailMessage;

        @Value("${mail.google.mail}")
        private String gmail;

        @Value("${mail.google.password}")
        private String gPw;

        public void sendEmail(String mail, String subject, String message) throws AddressException, MessagingException {
            log.debug("Setup Mail Server Properties");
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");
            log.debug("Mail Server Properties have been setup successfully..");

            log.debug("Get Mail Session");
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
            // generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(""));
            generateMailMessage.setSubject(subject);
            generateMailMessage.setContent(message, "text/html");
            log.debug("Mail Session has been created successfully..");

            log.debug("Session and Send mail");
            Transport transport = getMailSession.getTransport("smtp");

            transport.connect("smtp.gmail.com", gmail, gPw);
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
            log.debug("Mail has been sent");
        }
}
