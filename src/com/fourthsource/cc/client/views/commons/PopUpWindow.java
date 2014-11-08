package com.fourthsource.cc.client.views.commons;

import com.fourthsource.cc.shared.MessageType;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.constants.BackdropType;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class PopUpWindow {
	
	ModalWindow layout = new ModalWindow();

	public PopUpWindow(MessageType type, String message) {
		super();
//		layout.setTitle("Connected Care Message");
//		layout.setBackdrop(BackdropType.STATIC);
//		layout.setKeyboard(true);
//		layout.setAnimation(true);
	    layout.modal.add(layout.modalFooter);
	    
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
	
	public Modal getModal() {
		return layout.modal;
	}
	
}
