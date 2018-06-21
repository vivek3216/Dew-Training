package com.dew.training.app;

import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.dew.training.enums.MailMessageType;


@Component
public class MailContentProvider {

	@Autowired
	private VelocityEngine velocityEngine;
	
	public String getContent(MailMessageType messageType, Map<String, Object> model) {
		//logger.println(IMessage.DEBUG, "MailContentProvider.getContent()" + messageType);
		String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, messageType + ".vm", model);
		return content;
	}
}
