package com.bridgelabz.selenium.utility;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Send_Email {
    public static void Email() {

        // Create object of Property file
        Properties props = new Properties();

        // this will set host of server- you can change based on your requirement
        props.put("mail.smtp.host", "smtp.gmail.com");

        // set the port of socket factory
        props.put("mail.smtp.socketFactory.port", "465");

        // set socket factory
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        // set the authentication to true
        props.put("mail.smtp.auth", "true");

        // set the port of SMTP server
        props.put("mail.smtp.port", "465");

        // This will handle the complete authentication
        Session session = Session.getDefaultInstance(props,

                new javax.mail.Authenticator() {

                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication("chawattushar@gmail.com", "Tushar000@");

                    }

                });

        try {

            // Create object of MimeMessage class
            Message message = new MimeMessage(session);

            // Set the from address
            message.setFrom(new InternetAddress("chawattushar@gmail.com"));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("tushar1chawat@gmail.com"));

            // Add the subject link
            message.setSubject("Extent Report for BooksWagon");

            // Create object to add multimedia type content
            MimeBodyPart messageBodyPart1 = new MimeBodyPart();

            // Set the body of email
            messageBodyPart1.setText("Please find the below report for BooksWagon Test cases");

            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            // Mention the file which you want to send
            String Extent_Report = "Extent_Report.html";

            File att = new File(new File("C:\\Users\\Admin\\BooksWagon"), Extent_Report);
            messageBodyPart2.attachFile(att);

            // set the file
            messageBodyPart2.setFileName(Extent_Report);

            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();

            // add body part 1
            multipart.addBodyPart(messageBodyPart2);

            // add body part 2
            multipart.addBodyPart(messageBodyPart1);

            // set the content
            message.setContent(multipart);

            // finally send the email
            Transport.send(message);

            System.out.println("=====Email Sent=====");

        } catch (MessagingException | IOException e) {

            throw new RuntimeException(e);

        }

    }
}
