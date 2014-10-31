package com.fourthsource.cc.client;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.fourthsource.cc.shared.OrderConfirmation;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ConnectedCare implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Button button = new Button("Click Me");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TestService.Util.getService().getInfo(new MethodCallback<OrderConfirmation>() {
					@Override
					public void onSuccess(Method method, OrderConfirmation response) {
						RootPanel.get().add(new Label(response.toString()));
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
