package com.appx.work.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appx.work.domain.Series;
import com.appx.work.domain.SeriesDefinition;
import com.appx.work.service.AppxService;

@RestController
@RequestMapping(value = "/rest/appx/series")
public class AppxSeriesController {

	@Autowired
	private AppxService service;

	static Logger logger = LoggerFactory.getLogger(AppxSeriesController.class);

	@RequestMapping(method = RequestMethod.POST)
	public SeriesDefinition getSeries(@RequestBody SeriesDefinition defn) {
		return service.saveDefinition(defn);
	}

	@RequestMapping(value = "/{defId}/{start}/{increment}", method = RequestMethod.GET)
	public Series saveSeries(@PathVariable("defId") Long defId, @PathVariable("start") int start,
			@PathVariable("increment") int increment) {

		SeriesDefinition definition = service.getNumberSeriesById(defId);
		
		Series series = null;
		if (definition != null) {

			series = service.saveSeries(definition, start + "", increment);

		}

		return series;
	}

}
