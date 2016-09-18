package com.appx.work.service;

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

import ch.qos.logback.core.net.SyslogOutputStream;

// 
@ContextConfiguration(classes = { EmptyConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class SaveSeriesTest extends Assert {

	@Autowired
	AppxService appxService;

	@Test
	public void simpleSeries1() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4, x1+5 ");

		String result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue("1,2,3,4,5,6,?".equals(result));

		def = appxService.saveDefinition(def);

		Series ser = new Series();

		ser.setSeries(result);

		ser = appxService.saveSeries(def, ser);

		assertTrue(ser.getId() > 0);

		System.out.println(ser);

		SeriesDefinition sdef = appxService.getNumberSeriesById(def.getId());

		System.out.println(sdef);

	}

}
