package com.prakat.globalservice;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.prakat.model.UserDetailsVo;

@Service
@PropertySources({ @PropertySource("classpath:emailcontent.properties") })
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	Environment env;
	public boolean sendMail(String toAddress, String subject, String msgBody) {
		
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
				mimeMessage.setFrom(new InternetAddress("rhss@prakat.in"));
				mimeMessage.setSubject(subject);
				mimeMessage.setContent(msgBody, "text/html; charset=utf-8");
			}

		};
		mailSender.send(messagePreparator);
		return true;
	}
	
	public String prepareMail(UserDetailsVo userDetailsVO, String typeOfMail) {
		
		String msgBody = "";

		if ("Registration".equalsIgnoreCase(typeOfMail)) {

			msgBody = env.getProperty("registerHead1") + env.getProperty("registerHead2") + env.getProperty("registerHead3")
			+ env.getProperty("registerHead4") + env.getProperty("registerHead5") + env.getProperty("registerHead6")
			+ userDetailsVO.getFirstName() + " " + userDetailsVO.getLastName()
			+ env.getProperty("registerBody") + env.getProperty("registerForm") + userDetailsVO.getEmail()
			+ env.getProperty("registerCloseTag") + env.getProperty("registerOTP") + userDetailsVO.getVerificationCode()
			+ env.getProperty("registerCloseTag") + env.getProperty("registerVerifyBtn") +userDetailsVO.getEmail() 
			+env.getProperty("registerOTPAttribute") + userDetailsVO.getVerificationCode()+env.getProperty("registerAnchorCloseTag")
			+env.getProperty("registerCloseButtonTag")+ env.getProperty("registerVerifyEmailURL") + userDetailsVO.getEmail() 
			+ env.getProperty("registerOTPAttribute") +userDetailsVO.getVerificationCode() 
			+ env.getProperty("registerVerifyEmailLink") + env.getProperty("registerEndFormTag");

		} else if ("ResetPassword".equalsIgnoreCase(typeOfMail)) {

			msgBody = env.getProperty("resetPwdHead1") + env.getProperty("resetPwdHead2") + env.getProperty("resetPwdHead3")
					+ env.getProperty("resetPwdBody1") + env.getProperty("resetPwdBody2") + env.getProperty("resetPwdBody3")
					+ env.getProperty("resetPwdForm") + userDetailsVO.getEmail() + env.getProperty("resetPwdVerifycode")
					+ userDetailsVO.getVerificationCode() + env.getProperty("resetPwdTime")
					+ DateTime.now() + env.getProperty("resetPwdButton1") +userDetailsVO.getEmail()+ env.getProperty("resetClosetag")+env.getProperty("resetPwdanchor")+userDetailsVO.getEmail()+env.getProperty("resetClosetag")+env.getProperty("resetClickHere")+env.getProperty("resetPwdButton2")
					+ env.getProperty("resetPwdButton3");

		}

		return msgBody;
	}
	
}
