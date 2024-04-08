package com.example.medict2_0;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class javaMail {

    public static void main(String[] args) {
        final String username = "sece.ac.in";
        final String password = "BPRnEaas1C8pDDK9";
        sendMail();
    }

    public static void sendMail() {
        final String username = "sece.ac.in";
        final String password = "BPRnEaas1C8pDDK9";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.smtp2go.com");
        props.put("mail.smtp.port", "2525"); // 8025, 587 and 25 can also be used.

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            Multipart mp = new MimeMultipart("alternative");
            BodyPart textmessage = new MimeBodyPart();
            textmessage.setText("It is a text message n");
            BodyPart htmlmessage = new MimeBodyPart();
            htmlmessage.setContent("We hope this email finds you well. This is to confirm that your appointment has been successfully booked with KMCH.\n" +
                    "\n" +
                    "Appointment Details:\n" +
                    "\n" +
                    "Name: Muruga\n" +
                    "\n" +
                    "Date: 10/01/2024\n" +
                    "Time: 11 am\n" , "text/html");
            mp.addBodyPart(textmessage);
            mp.addBodyPart(htmlmessage);
            message.setFrom(new InternetAddress("dhevadharshini.m2022cce@sece.ac.in"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("ddmk010604@gmail.com"));
            message.setSubject("Appointment Confirmation - KMCH");
            message.setContent(mp);
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
