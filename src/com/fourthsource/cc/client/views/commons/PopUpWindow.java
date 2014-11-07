package com.fourthsource.cc.client.views.commons;

import com.fourthsource.cc.shared.MessageType;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class PopUpWindow extends DialogBox {
	
	TemplatePopUpWindow layout = new TemplatePopUpWindow();

	public PopUpWindow(MessageType type, String message) {
		super();
	    setText("Message Window");
	    setGlassEnabled(true);
        setAnimationEnabled(true);
	    setWidget(layout);
	    center();
	    
	    layout.setMessage(message);
	    
	    if(type.equals(MessageType.OK)) {
	    	layout.setImageSource("/images/accepted.png");
	    } else if(type.equals(MessageType.INFO)) {
	    	layout.setImageSource("/images/light_bulb.png");
	    } else if(type.equals(MessageType.QUESTION)) {
	    	layout.setImageSource("/images/question_mark.png");
	    	layout.setQuestionPopUp(true);
	    } else if(type.equals(MessageType.WARNING)) {
	    	layout.setImageSource("/images/warning.png");
	    } else if(type.equals(MessageType.ERROR)) {
	    	layout.setImageSource("/images/cancel.png");
	    }
	}
	
	public HandlerRegistration addOkButtonClickHandler(ClickHandler handler) {
		return layout.addOkButtonClickHandler(handler);
	}
	
	public HandlerRegistration addNoButtonClickHandler(ClickHandler handler) {
		return layout.addNoButtonClickHandler(handler);
	}
	
	public HandlerRegistration addCloseButtonClickHandler(ClickHandler handler) {
		return layout.addCloseButtonClickHandler(handler);
	}
	
}
