package com.dew.training.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dew.training.dto.EmailLog;
import com.dew.training.enums.MailMessageType;
import com.dew.training.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	@Override
	public void sendMail(MailMessageType messageType, Map<String, Object> params) {
		// TODO Auto-generated method stub
		
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

}
