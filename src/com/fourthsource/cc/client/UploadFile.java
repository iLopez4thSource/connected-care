package com.fourthsource.cc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class UploadFile implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel.get("content").add(new com.fourthsource.cc.client.views.upload.UploadFile());
	}

}
