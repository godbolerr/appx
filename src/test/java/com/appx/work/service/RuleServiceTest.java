package com.appx.work.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appx.work.config.EmptyConfig;
import com.appx.work.domain.SeriesDefinition;

@ContextConfiguration(classes = { EmptyConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleServiceTest extends Assert {

	private static final Logger LOGGER = LoggerFactory.getLogger(RuleServiceTest.class);

	@Autowired
	AppxService appxService;

	@Test
	public void testNumberSeriesForSquare() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1,2,3");		
		def.setIncrement(1);
		def.setEncodedSeries("x, x1+1 , x2+2, x3+ 3, x4+ 4, x5+5 ");

		System.out.println(appxService.generate(def));
	}
	

	public void testReplace() {

		String xstring = "x1 = x + 2";
	
		System.out.println(">> " + xstring.replaceAll("[a-z][0-9]*", "s.$0"));
	
	}
	

}
