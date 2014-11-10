package com.fourthsource.cc.client.views.main;

import java.util.ArrayList;
import java.util.List;

import com.fourthsource.cc.client.views.upload.UploadFile;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.github.gwtbootstrap.client.ui.SimplePager;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ImportData extends Composite {

	private static ImportDataUiBinder uiBinder = GWT.create(ImportDataUiBinder.class);
	@UiField HTMLPanel uploadFilePanel;
	@UiField VerticalPanel filesUploadedPanel;
	@UiField CellTable<String> filesUploadedTable;
	private List<String> listData = new ArrayList<>();

	interface ImportDataUiBinder extends UiBinder<Widget, ImportData> {
	}

	public ImportData() {
		initWidget(uiBinder.createAndBindUi(this));
		uploadFilePanel.add(new UploadFile());

		listData.add("File01.xlsx");
		listData.add("File02.xlsx");
		listData.add("File03.xlsx");
		listData.add("File04.xlsx");
		listData.add("File05.xlsx");
		listData.add("File06.xlsx");
		
		filesUploadedTable.setPageSize(4);
		filesUploadedTable.setAutoHeaderRefreshDisabled(true);
		filesUploadedTable.setAutoFooterRefreshDisabled(true);

		TextColumn<String> nameColumn = new TextColumn<String>() {
			@Override
		    public String getValue(String object) {
				return object;
			}
		};
		    
		filesUploadedTable.addColumn(nameColumn, "File Name");
		
	    AsyncDataProvider<String> provider = new AsyncDataProvider<String>() {
	    	@Override
	        protected void onRangeChanged(HasData<String> display) {
	    		int start = display.getVisibleRange().getStart();
	    		int end = start + display.getVisibleRange().getLength();
	    		
	    		end = end >= listData.size() ? listData.size() : end;
	    		List<String> sub = listData.subList(start, end);
	    		updateRowData(start, sub);
	        }
	    };
	    
		provider.addDataDisplay(filesUploadedTable);
		provider.updateRowCount(listData.size(), true);
		
		SimplePager pager = new SimplePager();
		pager.setDisplay(filesUploadedTable);
		filesUploadedPanel.add(pager);
	}
	
}
