package com.appx.work.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appx.work.service.RuleService;

@RestController
@RequestMapping(value = "/rest/appx/series")
public class AppxSeriesController {

	@Autowired
	private RuleService service;

	static Logger logger = LoggerFactory.getLogger(AppxSeriesController.class);

	@RequestMapping(method = RequestMethod.POST)
	public List<Integer> getSeries(@RequestBody String rule) {
		return service.getNumberSeries(rule);
	}

}
