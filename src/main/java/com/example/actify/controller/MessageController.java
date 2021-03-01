package com.example.actify.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.actify.model.Content;

@Controller
public class MessageController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/messages")
	  public Content message(Content request) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    String message = request.getMessage();
	    Content response = new Content();
	    if("Hi".equalsIgnoreCase(message)) {
	    	response.setMessage("Hi, how can I help you?");
	    }
	    else if("What is my current year sales?".equalsIgnoreCase(message)) {
	    	response.setMessage("Current year sales is 25 Cr");
	    }
	    else{
	    	response.setMessage("Sorry, didn't get that");
	    }
	    return response;
	  }


}