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

	private static final Logger LOGGER = LoggerFactory.getLogger(SaveSeriesTest.class);

	@Autowired
	AppxService appxService;

	@Test
	public void simpleSeries1() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4, x1+5 ");

		List<String> result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,2,3,4,5,6,?".equals(result.get(0)));
		
		def = appxService.saveRule(def);
		
		Series ser = new Series();
		
		ser.setSeries(result.get(0));
		
		ser = appxService.saveSeries(def, ser);
		
		assertTrue(ser.getId() > 0 );
		
		
		System.out.println(ser);
		
		
		SeriesDefinition sdef = appxService.getNumberSeriesById(def.getId());
		
		System.out.println(sdef);
		

	}
	
	
	@Test
	public void simpleSeries2() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1,6");
		def.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4, x1+5 ");

		List<String> result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue(result.size() == 2);
		assertTrue("1,2,3,4,5,6,?".equals(result.get(0)));
		
		def = appxService.saveRule(def);
		
		Series ser = new Series();
		
		ser.setSeries(result.get(0));
		
		ser = appxService.saveSeries(def, ser);
		
		assertTrue(ser.getId() > 0 );
		
		Series ser1 = new Series();
		
		ser1.setSeries(result.get(0));
		
		ser1 = appxService.saveSeries(def, ser1);
		
		assertTrue(ser1.getId() > 0 );
		
		System.out.println(ser1);
				
		SeriesDefinition sdef = appxService.getNumberSeriesById(def.getId());
		
		System.out.println(sdef);
		

	}

}
