package com.appx.work.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appx.work.common.AppxUtil;
import com.appx.work.service.AppxService;

@RestController
@RequestMapping(value = "/rest/appx/service")
public class AppxController {

	@Autowired
	private AppxService service;
	
	private AppxService servic2;

	static Logger logger = LoggerFactory.getLogger(AppxController.class);

	@RequestMapping(value = "/seed", method = RequestMethod.GET)
	public String seed() {

		AppxUtil.service = service;

		List<Long> ids = AppxUtil.loadDefinitionsFromFile(); //.loadDefinitions();

		return ids.toString();
	}

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public String loadData() {

		AppxUtil.service = service;
		
		System.out.println("Test load again for the first tim.");

		List<Long> ids = AppxUtil.loadData();

		return ids.toString();
	}

	@RequestMapping(value = "/seedAndLoad", method = RequestMethod.GET)
	public String seedAndLoadData() {

		AppxUtil.service = service;

		AppxUtil.loadDefinitions();
		
		List<Long> ids = AppxUtil.loadData();

		return ids.toString();
	}

}
