package com.appx.work.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appx.work.domain.NumberSeries;
import com.appx.work.service.AppxService;

@RestController
@RequestMapping(value = "/rest/appx/catalogue")
public class AppxCatController {

	@Autowired
	private AppxService service;

	static Logger logger = LoggerFactory.getLogger(AppxCatController.class);

	@RequestMapping(method = RequestMethod.POST)
	public NumberSeries addNumberSeries(@RequestBody NumberSeries catalogue) {
		return service.addNumberSeries(catalogue);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public NumberSeries editNumberSeries(@RequestBody NumberSeries catalogue) {

		return service.updateNumberSeries(catalogue);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteNumberSeries(@PathVariable("id") long id) {
		return service.deleteNumberSeries(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public NumberSeries getNumberSeries(@PathVariable("id") long id) {
		return service.getNumberSeriesById(id);
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public List<NumberSeries> getCalaloguesList() {
		return service.getNumberSeriesList();

	}

}
