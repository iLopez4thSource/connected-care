package com.fourthsource.cc.client.views.commons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Image;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class TemplatePopUpWindow extends Composite {

	private static TemplatePopUpWindowUiBinder uiBinder = GWT.create(TemplatePopUpWindowUiBinder.class);
	@UiField Image imageWindowType;
	@UiField InlineLabel labelMessage;
	@UiField Button okButton;
	@UiField Button noButton;
	@UiField Button cancelButton;
	
	interface TemplatePopUpWindowUiBinder extends UiBinder<Widget, TemplatePopUpWindow> {
	}

	public TemplatePopUpWindow() {
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
