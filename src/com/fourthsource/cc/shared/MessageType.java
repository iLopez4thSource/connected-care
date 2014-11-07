package com.fourthsource.cc.shared;

import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.google.gwt.core.shared.GWT;

public enum MessageType {

	OK,
	INFO,
	QUESTION,
	WARNING,
	ERROR;

	public interface MessageTypeJED extends JsonEncoderDecoder<MessageType> {
    }

    @Override
    public String toString() {
        if(GWT.isClient()) {
        	MessageTypeJED encoder = GWT.create(MessageTypeJED.class);
            return encoder.encode(this).toString();
        }
        
        return super.toString();
    }
	
}
