package com.fourthsource.cc.client.views.commons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.ModalFooter;

public class ModalWindow extends Composite {

	private static ModalWindowUiBinder uiBinder = GWT.create(ModalWindowUiBinder.class);
	@UiField public Modal modal;
	@UiField public ModalFooter modalFooter;
	@UiField Image imageWindowType;
	@UiField Label labelMessage;
	@UiField Button okButton;
	@UiField Button noButton;
	@UiField Button cancelButton;

	interface ModalWindowUiBinder extends UiBinder<Widget, ModalWindow> {
	}

	public ModalWindow() {
		initWidget(uiBinder.createAndBindUi(this));
		okButton.setVisible(false);
		noButton.setVisible(false);
		cancelButton.setText("Ok");
	}

	public void setMessage(String message) {
		labelMessage.setText(message);
	}
	
	public void setImageSource(String source) {
		imageWindowType.setUrl(source);
	}
	
	public void setQuestionPopUp(boolean flag) {
		if(flag) {
			okButton.setVisible(true);
			noButton.setVisible(true);
			cancelButton.setText("Cancel");
		} else {
			okButton.setVisible(false);
			noButton.setVisible(false);
			cancelButton.setText("Ok");
		}
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
