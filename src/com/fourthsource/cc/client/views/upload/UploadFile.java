package com.fourthsource.cc.client.views.upload;

import com.fourthsource.cc.client.views.commons.ModalWindow;
import com.fourthsource.cc.shared.ResponseFileUpload;
import com.fourthsource.cc.shared.ResponseFileUpload.ResponseFileUploadJED;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class UploadFile extends Composite {

	private static UploadFileUiBinder uiBinder = GWT.create(UploadFileUiBinder.class);
	@UiField AbsolutePanel absolutePanel;
	@UiField SimplePanel simplePanel;
	@UiField FormPanel form;
	@UiField FileUpload fileUpload;
	@UiField com.github.gwtbootstrap.client.ui.Button fileUploadButton;
	@UiField com.github.gwtbootstrap.client.ui.TextBox textBoxFileUpload;
	private ModalWindow modal;

	interface UploadFileUiBinder extends UiBinder<Widget, UploadFile> {
	}

	public UploadFile() {
		initWidget(uiBinder.createAndBindUi(this));

		form.setMethod(FormPanel.METHOD_POST);
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		
		fileUpload.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				textBoxFileUpload.setValue(fileUpload.getFilename());
			}
		});
		
		fileUploadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                fileUpload.setEnabled(true);
                form.submit();
            }
        });
        
        form.addSubmitHandler(new SubmitHandler() {
            @Override
            public void onSubmit(SubmitEvent event) {
            }
        });
        
        form.addSubmitCompleteHandler(new SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(SubmitCompleteEvent event) {
            	String JSONString = event.getResults().replace("<pre>", "").replace("</pre>", "");
            	JSONValue value = JSONParser.parseStrict(JSONString);
            	
            	ResponseFileUploadJED codec = GWT.create(ResponseFileUploadJED.class);
            	ResponseFileUpload response = codec.decode(value);
            	
                modal = new ModalWindow(response.getResponse().getMessageType(), response.getResponse().getMessage());
                
                modal.addCloseButtonClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						modal.hide();
					}
				});
                
                modal.show();
            }
        });
	}
	
}
