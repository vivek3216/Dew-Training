package com.dew.training.cron;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.dew.training.dto.EmailLog;
import com.dew.training.service.EmailService;

@Component
public class EmailCron extends BaseCron{

	@Autowired
	private EmailService emailService;	

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Override
	protected String getCronName() {
		return getClass().getSimpleName();
	}

	@Override
	protected void execute() throws Exception {
		//logger.println(IMessage.DEBUG, "EmailCron.execute() BEGIN");
		List<EmailLog> emailLogs = emailService.getAllUnsentEmails();
		//logger.println(IMessage.DEBUG, "EmailCron.execute() mail to process: " + emailLogs.size());
		List<EmailLog> sentEmailLogs = new ArrayList<EmailLog>();
		MimeMessage[] messagesArr= new MimeMessage[emailLogs.size()];
		int i=0;
		for(EmailLog emailLog:emailLogs){
			MimeMessage message=mailSender.createMimeMessage();
			populateEmailLogFields(emailLog, message);
			messagesArr[i]=message;
			//logger.println(IMessage.DEBUG, "EmailCron.execute() sending mail to " + emailLog.getToAddress());
			emailLog.setSent(true);
			emailLog.setSentOn(new Date());
			sentEmailLogs.add(emailLog);
			i++;
		}
		//mailSender.send(messagesArr);
		for(MimeMessage message:messagesArr){
			try {
				mailSender.send(message);
			} catch (Exception e) {
				//logger.println(IMessage.DEBUG, "EmailCron.execute() Not sending mails to :"+message.getAllRecipients().toString());
			}
		}
		emailService.updateSentStatus(sentEmailLogs);
		/*for(EmailLog emailLog:emailLogs){
			GeneralUtils.deleteAnIcsFile(emailLog.getToAddress().toString() + ".ics");
		}*/
	}

	private void populateEmailLogFields(EmailLog emailLog, MimeMessage message) throws MessagingException {
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(emailLog.getFromAddress());
		if (emailLog.getToAddress().indexOf(",") == -1) {
			helper.setTo(emailLog.getToAddress());
		} else {
			helper.setTo(emailLog.getToAddress().split(","));
		}
		if (emailLog.getCcAddress() != null) {
			helper.setCc(emailLog.getCcAddress());
		}
		if (emailLog.getBccAddress() != null) {
			helper.setBcc(emailLog.getBccAddress());
		}
		if (emailLog.getReplyToAddress() != null) {
			helper.setReplyTo(emailLog.getReplyToAddress());
		}
		helper.setSubject(emailLog.getSubject());
		helper.setText(emailLog.getBody(), true);
	}
}
