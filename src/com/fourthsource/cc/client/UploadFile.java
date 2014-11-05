package com.fourthsource.cc.client;

import com.fourthsource.cc.client.views.commons.Footer;
import com.fourthsource.cc.client.views.commons.Header;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class UploadFile implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel.get("header").add(new Header());
		RootPanel.get("content").add(new com.fourthsource.cc.client.views.upload.UploadFile());
		RootPanel.get("footer").add(new Footer());
	}

}
