package com.appx.work.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appx.work.config.EmptyConfig;
import com.appx.work.domain.Series;
import com.appx.work.domain.SeriesDefinition;
import com.appx.work.to.SeriesDefinitionTO;

// 
@ContextConfiguration(classes = { EmptyConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class SaveSeriesTest extends Assert {

	private static final Logger LOGGER = LoggerFactory.getLogger(SaveSeriesTest.class);

	@Autowired
	AppxService appxService;

	@Test
	public void simpleSeries1() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4, x1+5 ");

		String result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue("1,2,3,4,5,6".equals(result));

		def = appxService.saveDefinition(def);

		Series ser = new Series();

		ser.setSeries(result);

		ser = appxService.saveSeries(def, ser);

		assertTrue(ser.getId() > 0);

		LOGGER.debug(ser.toString());

		SeriesDefinitionTO sdef = appxService.getSeriesDefinition(def.getId());

		LOGGER.debug(sdef.toString());

	}

	@Test
	public void simpleSeries2() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4, x1+5 ");

		def = appxService.saveDefinition(def);

		assertTrue(def != null);
		assertTrue(def.getId() > 0);

		List<String> startNos = new ArrayList<String>();
		startNos.add("2");
		startNos.add("10");
		startNos.add("100");

		for (Iterator<String> iterator = startNos.iterator(); iterator.hasNext();) {
			String startNo = iterator.next();

			Series series = appxService.saveSeries(def, startNo);

			assertTrue(series != null);
			assertTrue(series.getId() > 0);
		}

		SeriesDefinitionTO stoDef = appxService.getSeriesDefinition(def.getId());

		int totalSeries = stoDef.getSeries().size();

		assertTrue(totalSeries == 3);

	}

}
