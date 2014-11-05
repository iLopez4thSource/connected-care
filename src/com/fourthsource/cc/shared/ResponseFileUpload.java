package com.fourthsource.cc.shared;

import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.google.gwt.core.shared.GWT;

public class ResponseFileUpload {

	private Message response;
	
    public interface ResponseFileUploadJED extends JsonEncoderDecoder<ResponseFileUpload> {
    }
	
    public ResponseFileUpload() {
    }
    
    @Override
    public String toString() {
        if(GWT.isClient()) {
        	ResponseFileUploadJED encoder = GWT.create(ResponseFileUploadJED.class);
            return encoder.encode(this).toString();
        }
        
        return super.toString();
    }

	public Message getResponse() {
		return response;
	}

	public void setResponse(Message response) {
		this.response = response;
	}
    
}
