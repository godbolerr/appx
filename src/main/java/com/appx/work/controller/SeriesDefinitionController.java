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

import com.appx.work.domain.SeriesDefinition;
import com.appx.work.service.AppxService;

@RestController
@RequestMapping(value = "/rest/appx/seriesdefn")
public class SeriesDefinitionController {

	@Autowired
	private AppxService service;

	static Logger logger = LoggerFactory.getLogger(SeriesDefinitionController.class);

	@RequestMapping(method = RequestMethod.POST)
	public SeriesDefinition addNumberSeries(@RequestBody SeriesDefinition seriesDefn) {
		return service.createSeriesDefinition(seriesDefn);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public SeriesDefinition editNumberSeries(@RequestBody SeriesDefinition seriesDefn) {

		return service.updateSeriesDefinition(seriesDefn);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteNumberSeries(@PathVariable("id") long id) {
		return service.deleteSeriesDefinition(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public SeriesDefinition getNumberSeries(@PathVariable("id") long id) {
		return service.getSeriesDefinition(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<SeriesDefinition> getNumberSeriesList() {
		return service.getAllSeriesDefinitions();

	}

}
