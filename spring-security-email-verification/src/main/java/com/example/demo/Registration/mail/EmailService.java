package com.example.demo.Registration.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailSender{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	@Async
	public void send(String to, String email) {
	try {	
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
		helper.setText(email,true);
		helper.setTo(to);
		helper.setSubject("confirm your email");
		helper.setFrom("valluru.1sujatha@gmail.com");
		
	}
	catch (MessagingException e) {
		throw new IllegalStateException("failed to send email");
	}
		
	}

}
