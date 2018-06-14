package com.dew.training.logging;

import org.apache.log4j.Logger;

public class MessageLog {

	private Logger logger;

	private MessageLog(Logger logger) {
		this.logger = logger;
	}

	public void println(int level, Object message) {
		switch (level) {
		case IMessage.DEBUG:
			logger.debug(message);
			break;
		case IMessage.ERROR:
			logger.error(message);
			break;
		case IMessage.FATAL:
			logger.fatal(message);
			break;
		case IMessage.INFO:
			logger.info(message);
			break;
		case IMessage.TRACE:
			logger.trace(message);
			break;
		case IMessage.WARN:
			logger.warn(message);
			break;
		default:
			break;
		}
	}

	public void println(int level, Object message, Throwable t) {
		switch (level) {
		case IMessage.DEBUG:
			logger.debug(message, t);
			break;
		case IMessage.ERROR:
			logger.error(message, t);			
			break;
		case IMessage.FATAL:
			logger.fatal(message, t);
			break;
		case IMessage.INFO:
			logger.info(message, t);
			break;
		case IMessage.TRACE:
			logger.trace(message, t);
			break;
		case IMessage.WARN:
			logger.warn(message, t);
			break;
		default:
			break;
		}
	}

    public static MessageLog getLogger(Class<?> clazz) {
		MessageLog messageLog = new MessageLog(Logger.getLogger(clazz));
		return messageLog;
	}

	public static MessageLog getLogger(String className) {
		MessageLog messageLog = new MessageLog(Logger.getLogger(className));
		return messageLog;
	}	
}
