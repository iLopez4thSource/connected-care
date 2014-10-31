package com.fourthsource.cc.shared;

import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.google.gwt.core.shared.GWT;

public class Message {
	
    public String message;
    public Long time;

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
    
}
