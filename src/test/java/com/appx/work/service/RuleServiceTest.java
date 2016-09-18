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
		def.setStartNumbers("1");
		def.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4, x1+5 ");

		List<String> result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,2,3,4,5,6,?".equals(result.get(0)));

	}

	@Test
	public void simpleSeries2() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4 ");

		List<String> result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,2,3,4,5,?".equals(result.get(0)));

	}

	@Test
	public void simpleSeries3() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setEncodedSeries("x, x1+1 ");

		List<String> result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,2,?".equals(result.get(0)));

	}
	

	@Test
	public void simpleSeriesWithTwoStarts() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1,2");
		def.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4, x1+5 ");

		List<String> result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue(result.size() == 2);
		assertTrue("1,2,3,4,5,6,?".equals(result.get(0)));
		assertTrue("2,3,4,5,6,7,?".equals(result.get(1)));
	}
	
	
	@Test
	public void squareSeries() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setEncodedSeries("x, (x1+1) * (x1+1) , (x1+2) * (x1+2) , (x1+3) * (x1+3) , (x1+4) * (x1+4) , (x1+5) * (x1+5) ");

		List<String> result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,4,9,16,25,36,?".equals(result.get(0)));
	}

	@Test
	public void cubeSeries() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setEncodedSeries("x, (x1+1) * (x1+1) * (x1+1) , (x1+2) * (x1+2) * (x1+2) , (x1+3) * (x1+3) * (x1+3), (x1+4) * (x1+4) * (x1+4), (x1+5) * (x1+5)* (x1+5) ");

		List<String> result = appxService.generate(def);
		
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,8,27,64,125,216,?".equals(result.get(0)));
	}
	
	@Test
	public void squareSeriesPlusOne() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setEncodedSeries("x, (x1+1) * (x1+1) +n , (x1+2) * (x1+2) + n , (x1+3) * (x1+3) +n , (x1+4) * (x1+4) +n  , (x1+5) * (x1+5) +n ");

		List<String> result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,5,10,17,26,37,?".equals(result.get(0)));
	}	
	
	

	@Test
	public void squareSeriesMinusOne() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setEncodedSeries("x, (x1+1) * (x1+1) - n , (x1+2) * (x1+2) - n , (x1+3) * (x1+3) - n , (x1+4) * (x1+4) - n  , (x1+5) * (x1+5) - n ");

		List<String> result = appxService.generate(def);

		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,3,8,15,24,35,?".equals(result.get(0)));
	}	
	
	@Test
	public void squareSeriesMinusTwo() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setIncrement(2);
		def.setEncodedSeries("x, (x1+1) * (x1+1) - n , (x1+2) * (x1+2) - n , (x1+3) * (x1+3) - n , (x1+4) * (x1+4) - n  , (x1+5) * (x1+5) - n ");

		List<String> result = appxService.generate(def);
		
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,2,7,14,23,34,?".equals(result.get(0)));
	}	
	
	
	
	@Test
	public void squareSeriesMultiply() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setIncrement(2);
		def.setEncodedSeries("x, (x1+1) *  n , (x1+2) *  n , (x1+3) *  n , (x1+4) *  n  , (x1+5) * n ");

		List<String> result = appxService.generate(def);
		
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,4,6,8,10,12,?".equals(result.get(0)));
	}	

	@Test
	public void squareSeriesMultiplyByThree() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setIncrement(3);
		def.setEncodedSeries("x, (x1+1) *  n , (x1+2) *  n , (x1+3) *  n , (x1+4) *  n  , (x1+5) * n ");

		List<String> result = appxService.generate(def);
		
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,6,9,12,15,18,?".equals(result.get(0)));
	}	
	

	//TODO Handle decimals in the service implementations.
	// Look at this series: 2, 1, (1/2), (1/4), ... What number should come next?
	@Test
	public void divideByHalf() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("10000");
		def.setIncrement(1);
		def.setEncodedSeries("x, x1/2, x1/4, x1/6, x1/8 , x1/16");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("10000,5000,2500,1666,1250,625,?".equals(result.get(0)));
	}	
	
	// 		Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come next?
	@Test
	public void alternateIncrease() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("1");
		def.setIncrement(2);
		def.setEncodedSeries("x, x1 + 5, x1 + n, x2 + n, x3 + n ,x4 + n,x5 + n,x6 + n");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("1,6,3,8,5,10,7,12,?".equals(result.get(0)));
	}	
	
	// 		Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come next?
	@Test	
	public void decreasingNumbers() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("36");
		def.setIncrement(2);
		def.setEncodedSeries("x, x1 -n , x2 -n , x3 - n , x4 -n , x5 - n");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("36,34,32,30,28,26,?".equals(result.get(0)));
	}	
	
	// 	Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come next?
	@Test	
	public void increasingDecresingAlternate() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("10");
		def.setIncrement(2);
		def.setEncodedSeries("x, x1 + 5, x1 + n, x2 - n, x3 + n, x4 - n, x5 + n , x6 - n ");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("10,15,12,13,14,11,16,9,?".equals(result.get(0)));
	}	
	
	
	@Test	
	public void stepIncrease() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("36");
		def.setIncrement(2);
		def.setEncodedSeries("x , x1 - n , x2 - 2 * n , x3 - n , x4 - 2 *n , x5 - n , x6 - 2 * n  ");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("36,34,30,28,24,22,18,?".equals(result.get(0)));
	}	
	
	@Test
	public void stepDecreaseWithSameNeighbour() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("36");
		def.setIncrement(7);
		def.setEncodedSeries("x , x1 , x2 - n , x2 - n , x3 - n , x3 - n , x5 - n , x5 -n  ");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("36,36,29,29,22,22,15,15,?".equals(result.get(0)));
	}	
	
	@Test
	public void alternateSameIncreasing() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("36");
		def.setIncrement(7);
		def.setEncodedSeries("x , x1 + n , x1 , x2 + n , x1 , x4 + n , x1 ");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("36,43,36,50,36,57,36,?".equals(result.get(0)));
	}	
	
	@Test
	public void alternateDescreasing() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("36");
		def.setIncrement(2);
		def.setEncodedSeries("x , x1 - n , x2 - 2 * n , x3 - n , x4 - 2 * n , x5 - n ");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("36,34,30,28,24,22,?".equals(result.get(0)));
	}		
	
	@Test
	public void alternateDouble() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("10");
		def.setIncrement(2);
		def.setEncodedSeries("x , x1 * n , x1 + 7 , x3 * n , x3 + 7 , x5 * n ");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("10,20,17,34,24,48,?".equals(result.get(0)));
	}		
	
	@Test
	public void diffisNextNumber() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("10");
		def.setIncrement(2);
		def.setEncodedSeries("x , n , x1 + x2 , n * 2 , x3 + x4 , n * 3, x5 + x6 , n * 4  ");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("10,2,12,4,16,6,22,8,?".equals(result.get(0)));
	}		
	
	@Test
	public void multOfPrevious() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("2");
		def.setIncrement(2);
		def.setEncodedSeries("x , x1 * x1 , x1 * x2 , x2 * x3 , x3 * x4 , x4 * x5 ");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("2,4,8,32,256,8192,?".equals(result.get(0)));
	}			

	@Test
	public void sumOfPrevious() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("2");
		def.setEncodedSeries("x , x1 + x1 , x1 + x2 , x2 + x3 , x3 + x4 , x4 + x5 ");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("2,4,6,10,16,26,?".equals(result.get(0)));
	}			
	
	@Test
	public void substractNFromBase() {

		SeriesDefinition def = new SeriesDefinition();
		def.setStartNumbers("100");
		def.setIncrement(3);
		def.setEncodedSeries("x , n,  x1 - n , n * 2 , x1 - x4 , n * 3 , x1 - x6 ");

		List<String> result = appxService.generate(def);
		System.out.println(result);
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue("100,3,97,6,94,9,91,?".equals(result.get(0)));
	}			
		
	//TODO Identify Pair
	//TODO Roman
	//TODO Decimal
	//TODO Alphabet
	
	
	
	
	
}
