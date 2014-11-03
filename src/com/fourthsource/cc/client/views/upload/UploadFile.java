package com.fourthsource.cc.client.views.upload;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UploadFile extends Composite {

	private static UploadFileUiBinder uiBinder = GWT.create(UploadFileUiBinder.class);

	interface UploadFileUiBinder extends UiBinder<Widget, UploadFile> {
		
	}

	public UploadFile() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
