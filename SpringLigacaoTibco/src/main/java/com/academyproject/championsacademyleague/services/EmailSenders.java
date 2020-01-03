package com.academyproject.championsacademyleague.services;
import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailSenders {
    public boolean sendEmail(String playerEmail){
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
            msg.setSubject("Welcome to the challenge");
            msg.setText("Welcome to the Polarising League. Dare to be the champion");
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
            msg.setSubject("");
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

}
