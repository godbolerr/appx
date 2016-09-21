package com.appx.work.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appx.work.config.EmptyConfig;
import com.appx.work.domain.Series;

// 
@ContextConfiguration(classes = { EmptyConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class UtilTests extends Assert {

	@Test
	public void checkHash() {

		Series ser = new Series();
		ser.setSeries("2,4,54,5,6,4");
		System.out.println(ser.getHashValue());
		
		ser.setSeries("2 3 4 * 5 6");
		System.out.println(ser.getHashValue());
	}

}
