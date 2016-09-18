package com.appx.work.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appx.work.domain.SeriesDefinition;
import com.appx.work.service.AppxService;

@RestController
@RequestMapping(value = "/rest/appx/service")
public class AppxController {

	@Autowired
	private AppxService service;

	static Logger logger = LoggerFactory.getLogger(AppxController.class);

	@RequestMapping(value = "/seed", method = RequestMethod.GET)
	public String seed() {

		List<Long> ids = new ArrayList<Long>();

		SeriesDefinition defn = null;

		defn = service.saveDefinition(new SeriesDefinition("SimpleSeries", "x, x1+1 , x1+2, x1+3, x1+4, x1+5"));
		ids.add(defn.getId());
		defn = service
				.saveDefinition(new SeriesDefinition("SimpleSeriesWithIncrement", "x, x1+n , x2+n, x3+n, x4+n, x5+n"));
		ids.add(defn.getId());

		defn = service.saveDefinition(new SeriesDefinition("SquareSeries",
				"x, (x1+1) * (x1+1) , (x1+2) * (x1+2) , (x1+3) * (x1+3) , (x1+4) * (x1+4) , (x1+5) * (x1+5) "));
		ids.add(defn.getId());

		defn = service.saveDefinition(new SeriesDefinition("CubeSeries",
				"x, (x1+1) * (x1+1) * (x1+1) , (x1+2) * (x1+2) * (x1+2) , (x1+3) * (x1+3) * (x1+3), (x1+4) * (x1+4) * (x1+4), (x1+5) * (x1+5)* (x1+5)"));
		ids.add(defn.getId());

		defn = service.saveDefinition(new SeriesDefinition("SquareSeriesPlusOne",
				"x, (x1+1) * (x1+1) +n , (x1+2) * (x1+2) + n , (x1+3) * (x1+3) +n , (x1+4) * (x1+4) +n  , (x1+5) * (x1+5) +n "));
		ids.add(defn.getId());

		defn = service.saveDefinition(new SeriesDefinition("SquareSeriesMinusOne",
				"x, (x1+1) * (x1+1) - n , (x1+2) * (x1+2) - n , (x1+3) * (x1+3) - n , (x1+4) * (x1+4) - n  , (x1+5) * (x1+5) - n "));
		ids.add(defn.getId());

		return ids.toString();
	}

}
