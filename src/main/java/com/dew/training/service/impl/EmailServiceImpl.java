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
			populateEmailLogFields(params, message,content);
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
	
	private void populateEmailLogFields(Map<String, Object> params, MimeMessage message,String content) throws MessagingException {
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("vivekp@dewsolutions.in");
		helper.setTo(params.get("email").toString());
		helper.setSubject("Welcome TO Dew Solutions");
		helper.setText(content, true);
	}

}
