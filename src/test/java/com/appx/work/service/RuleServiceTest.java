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

@ContextConfiguration(classes = { EmptyConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleServiceTest extends Assert {

	private static final Logger LOGGER = LoggerFactory.getLogger(RuleServiceTest.class);

	@Autowired
	AppxService appxService;

	@Test
	public void testNumberSeriesForSquare() {

		Map<String, Object> sourceData = new HashMap<String, Object>();
		Map<String, Object> destData = new HashMap<String, Object>();
		destData.put("z", "");
		String rule = new String("s.x = s.x * s.x ;");
		List<Integer> result = appxService.generateSeries(1,1,1,5,1,rule);
		LOGGER.debug(result.toString());
	}

	@Test
	public void testNumberSeriesForCube() {
		String rule = new String("s.x = s.x * s.x * s.x ;");
		List<Integer> result = appxService.generateSeries(1,1,1,5,1,rule);
		LOGGER.debug(result.toString());

	}

	@Test
	public void testNumberSeriesForIncrement() {
		String rule = new String("s.x = s.x + s.increment ;");
		List<Integer> result = appxService.generateSeries(1,1,1,5,1,rule);
		LOGGER.debug(result.toString());

	}

	@Test
	public void testNumberSeriesForIncrementWithSquare() {
		String rule = new String("s.x = s.x * s.x + s.increment ;");
		List<Integer> result = appxService.generateSeries(1,1,1,5,1,rule);
		LOGGER.debug(result.toString());

	}

	@Test
	public void testNumberSeriesForIncrementWithSquareOne() {
		String rule = new String("s.x = s.x * s.x + s.increment ;");
		List<Integer> result = appxService.generateSeries(1,1,1,5,1,rule);
		LOGGER.debug(result.toString());

	}

	@Test
	public void testNumberSeriesForIncrementWithSquareMultiplication() {
		String rule = new String("s.x = s.x * s.x + s.increment * s.increment;");
		List<Integer> result = appxService.generateSeries(1,1,1,5,1,rule);
		LOGGER.debug(result.toString());

	}

}
