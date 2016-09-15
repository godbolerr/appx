package com.appx.work.service;

import java.util.List;
import java.util.Map;

/**
 * Responsible for rule execution
 * 
 * @author 115750
 *
 */
public interface RuleService {

	public Map<String, Object> generate(Map<String, Object> sourceData, Map<String, Object> destData, String rule);
	
	public List<Integer> getNumberSeries(String rule);

}
