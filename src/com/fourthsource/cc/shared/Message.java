package com.fourthsource.cc.shared;

import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.google.gwt.core.shared.GWT;

public class Message {

	private int code;
    private String message;
    private MessageType messageType;

    public interface MessageJED extends JsonEncoderDecoder<Message> {
    }

    @Override
    public String toString() {
        if(GWT.isClient()) {
        	MessageJED encoder = GWT.create(MessageJED.class);
            return encoder.encode(this).toString();
        }
        
        return super.toString();
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
    
}
