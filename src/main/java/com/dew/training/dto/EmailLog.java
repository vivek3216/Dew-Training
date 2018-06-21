package com.dew.training.dto;

import java.util.Date;

public class EmailLog {


	private long emailLogId;
	private String fromAddress;
	private String toAddress;
	private String ccAddress;
	private String bccAddress;
	private String replyToAddress;
	private String subject;
	private String body;
	private boolean sent = false;
	private Date sentOn;
	private boolean isResent = false;
	
	public long getEmailLogId() {
		return emailLogId;
	}
	public void setEmailLogId(long emailLogId) {
		this.emailLogId = emailLogId;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getCcAddress() {
		return ccAddress;
	}
	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}
	public String getBccAddress() {
		return bccAddress;
	}
	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}
	public String getReplyToAddress() {
		return replyToAddress;
	}
	public void setReplyToAddress(String replyToAddress) {
		this.replyToAddress = replyToAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public boolean isSent() {
		return sent;
	}
	public void setSent(boolean sent) {
		this.sent = sent;
	}
	public Date getSentOn() {
		return sentOn;
	}
	public void setSentOn(Date sentOn) {
		this.sentOn = sentOn;
	}
	public boolean isResent() {
		return isResent;
	}
	public void setResent(boolean isResent) {
		this.isResent = isResent;
	}
}
