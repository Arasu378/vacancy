package com.arasu.vacancy.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailController {
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${support.email}")
	private String senderEmail;
	
	
	public void sendMail(String to, String subject, String body) throws MessagingException {
	    MimeMessage message = javaMailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    helper.setSubject(subject);
	    helper.setTo(to);
	    helper.setText(body, true);
	    helper.setFrom(senderEmail);
	    javaMailSender.send(message);
	}
}
