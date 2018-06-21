package com.dew.training.service;

import java.util.List;
import java.util.Map;

import com.dew.training.dto.EmailLog;
import com.dew.training.enums.MailMessageType;


public interface EmailService {
	
	void sendMail(MailMessageType messageType,Map<String, Object> params);

	List<EmailLog> getAllUnsentEmails();

	void updateSentStatus(List<EmailLog> sentEmailLogs);

}
