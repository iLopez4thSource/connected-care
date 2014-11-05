package com.fourthsource.cc.client;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.fourthsource.cc.client.service.TestService;
import com.fourthsource.cc.shared.Message;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class ConnectedCare implements EntryPoint {

	public void onModuleLoad() {
		Button button = new Button("Click Me");
		
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TestService.Util.getService().getInfo(new MethodCallback<Message>() {
					@Override
					public void onSuccess(Method method, Message response) {
						RootPanel.get().add(new Label("Message: " + response.getMessage()));
					}
					
					@Override
					public void onFailure(Method method, Throwable exception) {
						GWT.log("Error");
					}
				});
			}
		});
		
		RootPanel.get().add(button);
	}
}
