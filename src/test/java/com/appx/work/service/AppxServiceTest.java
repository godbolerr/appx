package com.appx.work.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appx.work.config.RootConfig;
import com.appx.work.domain.NumberSeries;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RootConfig.class)
public class AppxServiceTest {

	@Autowired
	AppxService service;

	@Test
	public void testAddNumberSeries() {
		
		NumberSeries numseries = new NumberSeries();

		numseries.setIncrement(1);
		numseries.setLevel(1);
		numseries.setRule("This is the rule");
		numseries.setSeries("1,2,3,4");
		numseries.setStart(1);
		numseries.setStep(1);
		numseries = service.addNumberSeries(numseries);

		assertTrue(numseries.getId() > 0);
	}

	@Test
	public void testUpdateNumberSeries() {
		NumberSeries numseries = new NumberSeries();

		numseries.setIncrement(1);
		numseries.setLevel(1);
		numseries.setRule("This is the rule");
		numseries.setSeries("1,2,3,4");
		numseries.setStart(1);
		numseries.setStep(1);
		numseries = service.addNumberSeries(numseries);
		assertTrue(numseries.getId() > 0);
	}

	@Test
	public void testGetNumberSeriesById() {
		NumberSeries numseries = new NumberSeries();

		numseries.setIncrement(1);
		numseries.setLevel(1);
		numseries.setRule("This is the rule");
		numseries.setSeries("1,2,3,4");
		numseries.setStart(1);
		numseries.setStep(1);
		numseries = service.addNumberSeries(numseries);

		assertTrue(numseries.getId() > 0);

		Long id = numseries.getId();

		NumberSeries newcat = service.getNumberSeriesById(id);

		assertTrue(newcat != null);

	}


	public void testGetNumberSeriesByName() {
		fail("Not yet implemented");
	}

	
	public void testDeleteNumberSeries() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumberSeriess() {

		NumberSeries numseries = new NumberSeries();

		numseries.setIncrement(1);
		numseries.setLevel(1);
		numseries.setRule("This is the rule");
		numseries.setSeries("1,2,3,4");
		numseries.setStart(1);
		numseries.setStep(1);
		numseries = service.addNumberSeries(numseries);

		
		numseries = new NumberSeries();

		numseries.setIncrement(1);
		numseries.setLevel(1);
		numseries.setRule("This is the rule");
		numseries.setSeries("1,2,3,4");
		numseries.setStart(1);
		numseries.setStep(1);
		numseries = service.addNumberSeries(numseries);
		
		
		List<NumberSeries> list = service.getNumberSeriesList();

		//assertTrue(list.size() > 0);

	}


	public void testGetPagedNumberSeriess() {
		fail("Not yet implemented");
	}

}
