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

import com.appx.work.domain.Series;
import com.appx.work.domain.SeriesDefinition;
import com.appx.work.service.AppxService;

@RestController
@RequestMapping(value = "/rest/appx/series")
public class SeriesController {

	@Autowired
	private AppxService service;

	static Logger logger = LoggerFactory.getLogger(SeriesController.class);

	@RequestMapping(method = RequestMethod.POST)
	public Series add(@RequestBody Series series) {
		return service.createSeries(series);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public Series update(@RequestBody Series series) {

		return service.udpateSeries(series);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Series delete(@PathVariable("id") long id) {
		return service.deleteSeries(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Series get(@PathVariable("id") long id) {
		return service.getSeries(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Series> getAllSeries() {
		return service.getAllSeries();

	}

	@RequestMapping(value = "/{defId}/{start}/{increment}", method = RequestMethod.GET)
	public Series createSeries(@PathVariable("defId") Long defId, @PathVariable("start") int start,
			@PathVariable("increment") int increment) {

		SeriesDefinition definition = service.getSeriesDefinition(defId);

		Series series = null;
		if (definition != null) {

			series = service.saveSeries(definition, start + "", increment);

		}

		return series;
	}
}
