package org.sercho.mail;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Notificator {
	
	public boolean sendSMS(String number, String text) {
		String body="Nummer: "+number+"\n" + text;
		return send("pia@pia-test2.aot.tu-berlin.de","SMS",body);
	}
	
	public boolean sendEmail(String emailaddress, String text) {
		return send(emailaddress, "Message from Notificator", text);
	}
	
	protected boolean send(String to, String subject, String body) {
		Session s = Session.getInstance(System.getProperties());
		try {
			Transport t = s.getTransport("smtp");
			t.connect("130.149.154.102", "Notificator", "");
			MimeMessage myMimeMessage = new MimeMessage(s);
			myMimeMessage.setFrom(new InternetAddress("notificator@dai-labor.de"));
			myMimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			myMimeMessage.setSubject(subject);
			myMimeMessage.setSentDate(new Date());
			myMimeMessage.setContent(body, "text/plain");
			t.sendMessage(myMimeMessage, myMimeMessage.getAllRecipients());
		} catch (NoSuchProviderException e) {
			System.err.println("no such provider!");
			return false;
		} catch (MessagingException e) {
			System.err.println("cannot send message!");
			return false;
		}
		return true;
	}

	
	public static void main(String[] args) {
		Notificator n= new Notificator();
		System.out.print("Sending Mail... ");
		System.out.println(n.sendEmail("tobias.kuester@gmx.net", "Hallo Welt"));
		System.out.println(n.sendEmail("tobias.kuester@dai-labor.de", "Hallo Welt"));
		System.out.print("Sending SMS... ");
		System.out.println(n.sendSMS("015159112421", "Hallo Welt"));
	}
}
