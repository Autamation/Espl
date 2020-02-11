package com.prakat.util;

import java.io.ByteArrayOutputStream;

import java.io.IOException;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.prakat.service.impl.ACheckerReportServiceImpl;

public class EmailSender {
	static Logger logger = Logger.getLogger(EmailSender.class.getName());

	  public static void main(String[] args) {
		
		
	  }
	  
	  public  boolean sendMail(String filename, XSSFWorkbook workbook, String emailId){
		  final String username = "rhss@prakat.in";
			final String password = "Prakat123";
            boolean isMailSend = false;
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.prakat.in");
			props.put("mail.smtp.port", "25");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {
				 DataSource ds = null;
				MimeMessage mimeMessage = new MimeMessage(session) ;
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
				mimeMessage.setFrom(new InternetAddress("rhss@prakat.in"));
				mimeMessage.setSubject("Web Accesibility Report Details from Prakat Solution");
			
				MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
				mimeBodyPart1.setText("Dear Sir/Madam"+"\n" +"\n"
						+"\n"+"                "

						+" Please find the attached spreadsheet containing the Accesibility issues in your web page"
						+"\n" +"\n" + "The summary of the report is as below"
						+"\n"+"\n"+""+
						"\n"+
						"\n"
						+"\n"+
						"\n"
						+ "Thanks You,"
						+"\n"+"\n"+""
						+ " Web Accessibility Team");

				
				// create the second message part
				 MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
				 
				 ByteArrayOutputStream baos = new ByteArrayOutputStream();
				 try{
					 workbook.write(baos);
				 byte[] bytes = baos.toByteArray();
				 ds = new ByteArrayDataSource(bytes, "application/excel");
				 }catch (IOException ioe ){
				 ioe.printStackTrace();
				 }
				 DataHandler dh = new DataHandler(ds);
				 mimeBodyPart2.setHeader("Content-Disposition", "attachment;filename="+filename);
				 mimeBodyPart2.setDataHandler(dh);
				 mimeBodyPart2.setFileName(filename);
				 
				 // create the Multipart and add its parts to it
				 Multipart multiPart = new MimeMultipart();
				 multiPart.addBodyPart(mimeBodyPart1);
				 multiPart.addBodyPart(mimeBodyPart2);
				 mimeMessage.setContent(multiPart);
			

				Transport.send(mimeMessage);
				isMailSend=true;
				logger.debug("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			 catch (Exception e) {
					logger.info(e.getMessage());
					e.printStackTrace();
				}
			return isMailSend;
	  }
}
	  
	  
	 
	

