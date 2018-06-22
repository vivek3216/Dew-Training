package com.dew.training.dao;

import java.util.List;

import com.dew.training.dto.EmailLog;

public interface EmailLogDAO {

	public long addEmailLog(EmailLog emailLog);
	
	List<EmailLog> getAllUnsentEmails();

	
}
