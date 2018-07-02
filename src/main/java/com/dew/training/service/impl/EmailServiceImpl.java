package com.dew.training.service.impl;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dew.training.app.MailContentProvider;
import com.dew.training.dto.EmailLog;
import com.dew.training.enums.MailMessageType;
import com.dew.training.service.EmailService;
import com.dew.training.util.ApplicationProperties;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Autowired
	private MailContentProvider mailContentProvider;
	
	@Override
	public void sendMail(MailMessageType messageType, Map<String, Object> params) {
		MimeMessage message=mailSender.createMimeMessage();
		String content = mailContentProvider.getContent(messageType, params);
		try {
			populateEmailLogFields(params, message,content,messageType);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mailSender.send(message);
		
	}

	@Override
	public List<EmailLog> getAllUnsentEmails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSentStatus(List<EmailLog> sentEmailLogs) {
		// TODO Auto-generated method stub
		
	}
	
	private void populateEmailLogFields(Map<String, Object> params, MimeMessage message,String content, MailMessageType messageType) throws MessagingException {
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(ApplicationProperties.getProperty("fromEmailAddress"));
		helper.setTo(params.get("email").toString());
		helper.setSubject(messageType.equals(MailMessageType.FORGOT_PASSWORD) ? ApplicationProperties.getProperty("forgotPasswordEmailSubject") : ApplicationProperties.getProperty("subject"));
		helper.setText(content, true);
	}

}
