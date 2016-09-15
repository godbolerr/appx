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

import com.appx.work.domain.Catalogue;
import com.appx.work.service.AppxService;

@RestController
@RequestMapping(value = "/rest/appx/catalogue")
public class AppxSeriesController {

	@Autowired
	private AppxService service;

	static Logger logger = LoggerFactory.getLogger(AppxSeriesController.class);

	@RequestMapping(method = RequestMethod.POST)
	public Catalogue addCatalogue(@RequestBody Catalogue catalogue) {
		return service.addCatalogue(catalogue);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public Catalogue editCatalogue(@RequestBody Catalogue catalogue) {

		return service.updateCatalogue(catalogue);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteCatalogue(@PathVariable("id") long id) {
		return service.deleteCatalogue(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Catalogue getCatalogue(@PathVariable("id") long id) {
		return service.getCatalogueById(id);
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public List<Catalogue> getCalaloguesList() {
		return service.getCatalogues();

	}

}
