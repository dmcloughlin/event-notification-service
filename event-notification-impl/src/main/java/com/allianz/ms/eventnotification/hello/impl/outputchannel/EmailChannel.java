package com.allianz.ms.eventnotification.hello.impl.outputchannel;

import com.allianz.ms.user.api.RegistrationEvent;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by dmcloughlin on 08/01/2018.
 */
public class EmailChannel implements Channel<RegistrationEvent> {

    @Override
    public void send(RegistrationEvent m) {

        RegistrationEvent.PolicyAndEmailCombinationVerified event =
                (RegistrationEvent.PolicyAndEmailCombinationVerified) m;

        final String username = "dmcloughlin@softwarecolony.com";
        final String password = "S1cr0S3rv1c3s";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "softwarecolony.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dmcloughlin@softwarecolony.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("dmcloughlin@softwarecolony.com"));
            message.setSubject("Allianz - Instructions for Sign up.");
            message.setText("Dear " + event.getEmail()
                    + "\n\n Instructions follow!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}