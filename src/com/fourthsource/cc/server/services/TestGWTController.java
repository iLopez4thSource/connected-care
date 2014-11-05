package com.fourthsource.cc.server.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fourthsource.cc.shared.Message;

@Controller
public class TestGWTController {
	
	@RequestMapping(value = "/getMessage", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Message getMessage() {
		Message message = new Message();
		message.setMessage("Hello");
		return message;
	}
	
}
