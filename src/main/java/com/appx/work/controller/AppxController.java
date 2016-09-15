package com.appx.work.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appx.work.service.AppxService;

@RestController
@RequestMapping(value = "/rest/appx")
public class AppxController {

	@Autowired
	private AppxService fasService;

	static Logger logger = LoggerFactory.getLogger(AppxController.class);

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public Long createTestRecord() {

		return 100l;

	}

}
