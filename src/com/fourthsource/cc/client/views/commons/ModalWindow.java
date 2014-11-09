package com.fourthsource.cc.client.views.commons;

import com.fourthsource.cc.shared.MessageType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.constants.IconType;

public class ModalWindow extends Composite {

	private static ModalWindowUiBinder uiBinder = GWT.create(ModalWindowUiBinder.class);
	@UiField Modal modal;
	@UiField Image imageWindowType;
	@UiField Label labelMessage;
	@UiField Button okButton;
	@UiField Button noButton;
	@UiField Button cancelButton;

	interface ModalWindowUiBinder extends UiBinder<Widget, ModalWindow> {
	}

	public ModalWindow(MessageType type, String message) {
		initWidget(uiBinder.createAndBindUi(this));
		this.setDefaultButtons();
		labelMessage.setText(message);
		
	    if(type.equals(MessageType.OK)) {
	    	imageWindowType.setUrl("/images/accepted.png");
	    } else if(type.equals(MessageType.INFO)) {
	    	imageWindowType.setUrl("/images/light_bulb.png");
	    } else if(type.equals(MessageType.QUESTION)) {
	    	imageWindowType.setUrl("/images/question_mark.png");
	    	this.setQuestionPopUp(true);
	    } else if(type.equals(MessageType.WARNING)) {
	    	imageWindowType.setUrl("/images/warning.png");
	    } else if(type.equals(MessageType.ERROR)) {
	    	imageWindowType.setUrl("/images/cancel.png");
	    }
	}
	
	private void setDefaultButtons() {
		okButton.setVisible(false);
		noButton.setVisible(false);
		cancelButton.setText("Ok");
		cancelButton.setIcon(IconType.OK);
	}
	
	private void setQuestionPopUp(boolean flag) {
		if(flag) {
			okButton.setVisible(true);
			noButton.setVisible(true);
			cancelButton.setText("Cancel");
			cancelButton.setIcon(IconType.REMOVE);
		} else {
			this.setDefaultButtons();
		}
	}
	
	public void show() {
        RootPanel.get("modal").add(this);
		modal.show();
	}
	
	public void hide() {
		modal.hide();
		RootPanel.get("modal").remove(this);
	}
	
	public HandlerRegistration addOkButtonClickHandler(ClickHandler handler) {
		return okButton.addClickHandler(handler);
	}
	
	public HandlerRegistration addNoButtonClickHandler(ClickHandler handler) {
		return noButton.addClickHandler(handler);
	}
	
	public HandlerRegistration addCloseButtonClickHandler(ClickHandler handler) {
		return cancelButton.addClickHandler(handler);
	}
	
}
