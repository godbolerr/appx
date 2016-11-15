package com.appx.work.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value = "/rest/appx/service")
public class AppxController {

	
	static Logger logger = LoggerFactory.getLogger(AppxController.class);

	@RequestMapping(value = "/seed", method = RequestMethod.GET)
	public String seed() {
		return "Got it";
	}
}
