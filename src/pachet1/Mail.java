package pachet1;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Clasa pentru setarea operatiei de trimitere a codului pin pe email pentru validarea platii unei facturi
 */

public class Mail
{

	//SETUP MAIL SERVER PROPERTIES
	//DRAFT AN EMAIL
	//SEND EMAIL
		
	Session newSession = null;
	MimeMessage mimeMessage = null;

	public void sendEmail() throws MessagingException {
		String fromUser = "testbancar@gmail.com";  //Enter sender email id
		String fromUserPassword = "parolaqwerty10";  //Enter sender gmail password , this will be authenticated by gmail smtp server
		String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
	}

	public MimeMessage draftEmail(String email, int cod) throws AddressException, MessagingException, IOException {
		String[] emailReceipients = {"testbancar@gmail.com"};  //Enter list of email recepients
		String emailSubject = "TestBanca cod";
		String emailBody = "Code: " + cod;
		mimeMessage = new MimeMessage(newSession);
		
		
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		
		mimeMessage.setSubject(emailSubject);
	    
	    
		 MimeBodyPart bodyPart = new MimeBodyPart();
		 bodyPart.setText(emailBody);
		 MimeMultipart multiPart = new MimeMultipart();
		 multiPart.addBodyPart(bodyPart);
		 mimeMessage.setContent(multiPart);
		 return mimeMessage;
	}

	public void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(properties,null);
	}
	
}	
