package com.bootcamp.addTen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddTenController {
	
	Logger logger = LoggerFactory.getLogger(AddTenController.class);
	
	public static String INVALID_INPUT_MESSAGE = "Input is not in integer form. Please enter valid Integer input";
	
	@GetMapping("/addTen/{num}")
	public String addTenToInput(@PathVariable(value = "num") String input) {
		logger.debug("In addTenToInput" + input );
		int num=0;	
		
		try {
			 num = Integer.parseInt(input);
		} catch (NumberFormatException exception) {
			logger.debug("Number format exception");
			return INVALID_INPUT_MESSAGE;
        } 
		String result = num+10+"";
	    return result;
	}
	
}
