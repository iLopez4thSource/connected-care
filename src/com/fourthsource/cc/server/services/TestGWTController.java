package com.fourthsource.cc.server.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fourthsource.cc.shared.OrderConfirmation;

@Controller
@RequestMapping("/testService")
public class TestGWTController {
	@RequestMapping(value = "/loadInfo", method = RequestMethod.GET, headers = "Accept=application/json")
	
	public @ResponseBody OrderConfirmation handleRequest() {
		
		OrderConfirmation confirmation = new OrderConfirmation();
		confirmation.message = "Hello";
        confirmation.ready_time = System.currentTimeMillis() + 1000 * 60 * 30;
        
		return confirmation;
	}
}
