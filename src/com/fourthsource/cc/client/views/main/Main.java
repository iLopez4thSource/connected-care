package com.fourthsource.cc.client.views.main;

import com.github.gwtbootstrap.client.ui.AlertBlock;
import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Main extends Composite {

	private static MainUiBinder uiBinder = GWT.create(MainUiBinder.class);
	@UiField VerticalPanel verticalPanel;
	private HTMLPanel mainPanel = new HTMLPanel("");

	interface MainUiBinder extends UiBinder<Widget, Main> {
	}

	public Main() {
		initWidget(uiBinder.createAndBindUi(this));
		mainPanel.add(new ImportData());
		verticalPanel.add(createHeader());
		verticalPanel.add(mainPanel);
	}
	
	private AlertBlock createHeader() {
		AlertBlock header = new AlertBlock();
		
		header.setType(AlertType.INFO);
		header.setClose(false);
		header.setHeading("Import Data");
		
		return header;
	}

}
