package com.service;

import java.io.FileReader;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	public static void sendMail(String toEmail) {
		Properties pro = new Properties();
		pro.put("mail.smtp.auth", "true");
		//pro.put("mail.smtp.starttls.enable", "true");
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.port", "465");
		pro.put("mail.smtp.socketFactory.port", "465");
        pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		String email = "siddharth.joshi@hotwaxsystems.com";
		String password = "Asdf@123";
		
		Session session = Session.getInstance(pro, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		
		 try {
	           Message message = new MimeMessage(session);
	           message.setFrom(new InternetAddress(email));
	           message.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
	           message.setSubject("Registered Successfully...");
	            Transport.send(message);
	            System.out.println("Message Sent Successfully");
	        }
		 catch (Exception e) {
			 e.printStackTrace();
		}
	    }
}