package com.appx.work.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class PatternMatchTest extends Assert {
	
	/**
	 * 
	 * 
	 * 	Enter your regex: x\Q(\E[a-zA-Z] [\+ \-] \d\Q)\E*
		Enter input string to search: x(n) = x(n + 1)
		I found the text "(n + 1)" starting at index 8 and ending at index 15.
		
		s.firstPositionValue
		s.step
		s.increment 
		
		s.x(n) = s.x(n) + 1 ;
		
		\Q(\En[\+\-]\d\Q)\E*
		
	 */

	@Test
	public void testPatternMatch() {
		String rule = new String(
				"s.firstNumber=5;s.step = 2; s.totalCount=5;s.increment = 3 ; s.x(n) = s.x(n) * s.x(n-1) + s.increment * s.increment;");

		
		

	}

}
