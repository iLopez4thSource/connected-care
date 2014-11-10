package com.fourthsource.cc.client.views.main;

import java.util.ArrayList;
import java.util.List;

import com.fourthsource.cc.client.views.upload.UploadFile;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.github.gwtbootstrap.client.ui.SimplePager;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ImportData extends Composite {

	private static ImportDataUiBinder uiBinder = GWT.create(ImportDataUiBinder.class);
	@UiField HTMLPanel uploadFilePanel;
	@UiField VerticalPanel filesUploadedPanel;
	@UiField CellTable<String> filesUploadedTable;

	interface ImportDataUiBinder extends UiBinder<Widget, ImportData> {
	}

	public ImportData() {
		initWidget(uiBinder.createAndBindUi(this));
		uploadFilePanel.add(new UploadFile());
		
		filesUploadedTable.setPageSize(3);
		filesUploadedTable.setWidth("100%", true);

			    // Do not refresh the headers and footers every time the data is updated.
		filesUploadedTable.setAutoHeaderRefreshDisabled(true);
		filesUploadedTable.setAutoFooterRefreshDisabled(true);

		TextColumn<String> nameColumn = new TextColumn<String>() {
		      @Override
		      public String getValue(String object) {
		        return object;
		      }
		    };
		    filesUploadedTable.addColumn(nameColumn, "Columna1");
		
		    AsyncDataProvider<String> provider = new AsyncDataProvider<String>() {
		        @Override
		        protected void onRangeChanged(HasData<String> display) {
		          int start = display.getVisibleRange().getStart();
		          int end = start + display.getVisibleRange().getLength();
		          end = end >= 4 ? 4 : end;
		          List<String> sub = new ArrayList<String>();
//		          List<Contact> sub = CONTACTS.subList(start, end);
		          sub.add("dddd");
		          sub.add("ddffeedd");
		          sub.add("dddwrrrd");
		          sub.add("dddwrrdsssrd");
		          
		          updateRowData(start, sub);
		        }
		      };
		      provider.addDataDisplay(filesUploadedTable);
		      provider.updateRowCount(4, true);
		      
		      SimplePager pager = new SimplePager();
		      pager.setDisplay(filesUploadedTable);
		      
		      filesUploadedPanel.add(pager);

			  }

}
