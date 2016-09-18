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
import com.appx.work.domain.SeriesDefinition;

// 
@ContextConfiguration(classes = { EmptyConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleServiceTest extends Assert {

	private static final Logger LOGGER = LoggerFactory.getLogger(RuleServiceTest.class);

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

	}

	@Test
	public void simpleSeries2() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4 ");

		String result = appxService.generate(def);

		assertTrue(result != null);

		assertTrue("1,2,3,4,5".equals(result));

	}

	@Test
	public void simpleSeries3() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setEncodedSeries("x, x1+1 ");

		String result = appxService.generate(def);

		assertTrue(result != null);

		assertTrue("1,2".equals(result));

	}

	@Test
	public void simpleSeriesWithTwoStarts() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4, x1+5 ");

		String result = appxService.generate(def);

		assertTrue(result != null);

		assertTrue("1,2,3,4,5,6".equals(result));

	}

	@Test
	public void squareSeries() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setEncodedSeries(
				"x, (x1+1) * (x1+1) , (x1+2) * (x1+2) , (x1+3) * (x1+3) , (x1+4) * (x1+4) , (x1+5) * (x1+5) ");

		String result = appxService.generate(def);

		assertTrue(result != null);

		assertTrue("1,4,9,16,25,36".equals(result));
	}

	@Test
	public void cubeSeries() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setEncodedSeries(
				"x, (x1+1) * (x1+1) * (x1+1) , (x1+2) * (x1+2) * (x1+2) , (x1+3) * (x1+3) * (x1+3), (x1+4) * (x1+4) * (x1+4), (x1+5) * (x1+5)* (x1+5) ");

		String result = appxService.generate(def);

		assertTrue(result != null);

		assertTrue("1,8,27,64,125,216".equals(result));
	}

	@Test
	public void squareSeriesPlusOne() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setEncodedSeries(
				"x, (x1+1) * (x1+1) +n , (x1+2) * (x1+2) + n , (x1+3) * (x1+3) +n , (x1+4) * (x1+4) +n  , (x1+5) * (x1+5) +n ");

		String result = appxService.generate(def);

		assertTrue(result != null);

		assertTrue("1,5,10,17,26,37".equals(result));
	}

	@Test
	public void squareSeriesMinusOne() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setEncodedSeries(
				"x, (x1+1) * (x1+1) - n , (x1+2) * (x1+2) - n , (x1+3) * (x1+3) - n , (x1+4) * (x1+4) - n  , (x1+5) * (x1+5) - n ");

		String result = appxService.generate(def);

		assertTrue(result != null);

		assertTrue("1,3,8,15,24,35".equals(result));
	}

	@Test
	public void squareSeriesMinusTwo() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setIncrement(2);
		def.setEncodedSeries(
				"x, (x1+1) * (x1+1) - n , (x1+2) * (x1+2) - n , (x1+3) * (x1+3) - n , (x1+4) * (x1+4) - n  , (x1+5) * (x1+5) - n ");

		String result = appxService.generate(def);

		assertTrue(result != null);

		assertTrue("1,2,7,14,23,34".equals(result));
	}

	@Test
	public void squareSeriesMultiply() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setIncrement(2);
		def.setEncodedSeries("x, (x1+1) *  n , (x1+2) *  n , (x1+3) *  n , (x1+4) *  n  , (x1+5) * n ");

		String result = appxService.generate(def);

		assertTrue(result != null);

		assertTrue("1,4,6,8,10,12".equals(result));
	}

	@Test
	public void squareSeriesMultiplyByThree() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setIncrement(3);
		def.setEncodedSeries("x, (x1+1) *  n , (x1+2) *  n , (x1+3) *  n , (x1+4) *  n  , (x1+5) * n ");

		String result = appxService.generate(def);

		assertTrue(result != null);

		assertTrue("1,6,9,12,15,18".equals(result));
	}

	// TODO Handle decimals in the service implementations.
	// Look at this series: 2, 1, (1/2), (1/4), ... What number should come
	// next?
	@Test
	public void divideByHalf() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("10000");
		def.setIncrement(1);
		def.setEncodedSeries("x, x1/2, x1/4, x1/6, x1/8 , x1/16");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("10000,5000,2500,1666,1250,625".equals(result));
	}

	// Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come
	// next?
	@Test
	public void alternateIncrease() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("1");
		def.setIncrement(2);
		def.setEncodedSeries("x, x1 + 5, x1 + n, x2 + n, x3 + n ,x4 + n,x5 + n,x6 + n");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("1,6,3,8,5,10,7,12".equals(result));
	}

	// Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come
	// next?
	@Test
	public void decreasingNumbers() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("36");
		def.setIncrement(2);
		def.setEncodedSeries("x, x1 -n , x2 -n , x3 - n , x4 -n , x5 - n");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("36,34,32,30,28,26".equals(result));
	}

	// Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come
	// next?
	@Test
	public void increasingDecresingAlternate() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("10");
		def.setIncrement(2);
		def.setEncodedSeries("x, x1 + 5, x1 + n, x2 - n, x3 + n, x4 - n, x5 + n , x6 - n ");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("10,15,12,13,14,11,16,9".equals(result));
	}

	@Test
	public void stepIncrease() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("36");
		def.setIncrement(2);
		def.setEncodedSeries("x , x1 - n , x2 - 2 * n , x3 - n , x4 - 2 *n , x5 - n , x6 - 2 * n  ");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("36,34,30,28,24,22,18".equals(result));
	}

	@Test
	public void stepDecreaseWithSameNeighbour() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("36");
		def.setIncrement(7);
		def.setEncodedSeries("x , x1 , x2 - n , x2 - n , x3 - n , x3 - n , x5 - n , x5 -n  ");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("36,36,29,29,22,22,15,15".equals(result));
	}

	@Test
	public void alternateSameIncreasing() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("36");
		def.setIncrement(7);
		def.setEncodedSeries("x , x1 + n , x1 , x2 + n , x1 , x4 + n , x1 ");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("36,43,36,50,36,57,36".equals(result));
	}

	@Test
	public void alternateDescreasing() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("36");
		def.setIncrement(2);
		def.setEncodedSeries("x , x1 - n , x2 - 2 * n , x3 - n , x4 - 2 * n , x5 - n ");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("36,34,30,28,24,22".equals(result));
	}

	@Test
	public void alternateDouble() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("10");
		def.setIncrement(2);
		def.setEncodedSeries("x , x1 * n , x1 + 7 , x3 * n , x3 + 7 , x5 * n ");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("10,20,17,34,24,48".equals(result));
	}

	@Test
	public void diffisNextNumber() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("10");
		def.setIncrement(2);
		def.setEncodedSeries("x , n , x1 + x2 , n * 2 , x3 + x4 , n * 3, x5 + x6 , n * 4  ");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("10,2,12,4,16,6,22,8".equals(result));
	}

	@Test
	public void multOfPrevious() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("2");
		def.setIncrement(2);
		def.setEncodedSeries("x , x1 * x1 , x1 * x2 , x2 * x3 , x3 * x4 , x4 * x5 ");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("2,4,8,32,256,8192".equals(result));
	}

	@Test
	public void sumOfPrevious() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("2");
		def.setEncodedSeries("x , x1 + x1 , x1 + x2 , x2 + x3 , x3 + x4 , x4 + x5 ");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("2,4,6,10,16,26".equals(result));
	}

	@Test
	public void substractNFromBase() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumber("100");
		def.setIncrement(3);
		def.setEncodedSeries("x , n,  x1 - n , n * 2 , x1 - x4 , n * 3 , x1 - x6 ");

		String result = appxService.generate(def);
		LOGGER.debug(result);
		assertTrue(result != null);

		assertTrue("100,3,97,6,94,9,91".equals(result));
	}

	// TODO Identify Pair
	// TODO Roman
	// TODO Decimal
	// TODO Alphabet

}
