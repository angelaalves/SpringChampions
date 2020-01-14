package com.academyproject.championsacademyleague.services;
import com.sun.mail.smtp.SMTPTransport;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class EmailSenders {
    public boolean sendEmail(String playerEmail, String randomPass){
        Properties prop=System.getProperties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail_smtp.auth", "true");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session= Session.getInstance(prop, null);
        Message msg=new MimeMessage(session);
        MimeMultipart multipart = new MimeMultipart("related");
        MimeBodyPart bodyPart = new MimeBodyPart();
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        //String htmlMessage = "<html><body><img src=\"cid:image\"></body></html>";
        String htmlMessage = "<html>" +
                "<body>" +
                    "<div class=\"container\" style=\"position: relative; color: black;\">" +
                        "Welcome to the Champions' Academy League!" + "<br>" +
                        "Your account details are as follow: <br>" +
                        "Username: "+ playerEmail + "<br>" +
                        "Password: "+ randomPass + "<br>" +
                        "Dare to be the Champion!" + "<br>" +
                "<img src=\"cid:image\" >" +
                "</div>" +
                "</body>" +
                "</html>";
        try{
            msg.setFrom(new InternetAddress("championspolarisingleague@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(playerEmail, false));
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse("", false));
            msg.setSubject("Welcome to the challenge");
            //msg.setText("Welcome to the Polarising League.\n Your account details are as follow:\nuserName: "+playerEmail+"\npassword: "+randomPass+"\nDare to be the champion \n");
            msg.setSentDate(new Date());
            //msg.setContent(htmlMessage, "text/html");
            FileDataSource fds = new FileDataSource("C:/Users/carolina.martins/OneDrive - P8G Group, Lda/SpringChampions/SpringLigacaoTibco/src/main/java/com/academyproject/championsacademyleague/services/emailbackground.jpg");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            //htmlMessage+="Welcome to the Polarising League.\n Your account details are as follow:\nuserName: "+playerEmail+"\npassword: "+randomPass+"\nDare to be the champion \n";
            bodyPart.setContent(htmlMessage , "text/html; charset=utf-8");
            //messageBodyPart.setContent("Welcome to the Polarising League.\n Your account details are as follow:\nuserName: "+playerEmail+"\npassword: "+randomPass+"\nDare to be the champion \n", "text/html; charset=UTF-8");
            bodyPart.setDisposition(MimeBodyPart.INLINE);
            multipart.addBodyPart(bodyPart);
            multipart.addBodyPart(messageBodyPart);
            msg.setContent(multipart);
            SMTPTransport t= (SMTPTransport) session.getTransport("smtp");
            t.connect("smtp.gmail.com", "championspolarisingleague@gmail.com", "apasseeentrar");
            t.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Response: "+t.getLastServerResponse());
            t.close();
            return true;
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean forgotPasswordMail(String playerEmail, String randomPass){
        Properties prop=System.getProperties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail_smtp.auth", "true");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session= Session.getInstance(prop, null);
        Message msg=new MimeMessage(session);
        try{
            msg.setFrom(new InternetAddress("championspolarisingleague@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(playerEmail, false));
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse("", false));
            msg.setSubject("reset password");
            msg.setText("Your account password was randomly generated to help you recover your account. \n Your new password is: "+randomPass);
            msg.setSentDate(new Date());
            SMTPTransport t= (SMTPTransport) session.getTransport("smtp");
            t.connect("smtp.gmail.com", "championspolarisingleague@gmail.com", "apasseeentrar");
            t.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Response: "+t.getLastServerResponse());
            t.close();
            return true;
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changedPasswordMail(String playerEmail){
        Properties prop=System.getProperties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail_smtp.auth", "true");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session= Session.getInstance(prop, null);
        Message msg=new MimeMessage(session);
        try{
            msg.setFrom(new InternetAddress("championspolarisingleague@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(playerEmail, false));
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse("", false));
            msg.setSubject("Password Changed");
            msg.setText("This automated email was sent because we detect your password as changed");
            msg.setSentDate(new Date());
            SMTPTransport t= (SMTPTransport) session.getTransport("smtp");
            t.connect("smtp.gmail.com", "championspolarisingleague@gmail.com", "apasseeentrar");
            t.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Response: "+t.getLastServerResponse());
            t.close();
            return true;
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }
}