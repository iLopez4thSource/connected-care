package com.fourthsource.cc.client.views.main;

import com.fourthsource.cc.client.views.upload.UploadFile;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;

public class ImportData extends Composite {

	private static ImportDataUiBinder uiBinder = GWT.create(ImportDataUiBinder.class);
	@UiField HTMLPanel uploadFilePanel;

	interface ImportDataUiBinder extends UiBinder<Widget, ImportData> {
	}

	public ImportData() {
		initWidget(uiBinder.createAndBindUi(this));
		uploadFilePanel.add(new UploadFile());
	}

}
