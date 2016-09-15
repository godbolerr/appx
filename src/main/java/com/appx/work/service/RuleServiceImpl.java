/**
 * 
 */
package com.appx.work.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlScript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appx.work.common.AppConstants;
import com.appx.work.domain.Catalogue;

/**
 * @author 115750
 *
 */
@Service
public class RuleServiceImpl implements RuleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RuleServiceImpl.class);

	java.util.Map<String, Object> funcs = new java.util.HashMap<String, Object>();

	JexlEngine jexl = new JexlBuilder().cache(512).strict(true).silent(false).create();

	@Autowired
	UtilityFunctionService service;

	@Autowired
	AppxService appxService;
	/**
	 * 
	 */
	public RuleServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appx.work.service.RuleService#generate(java.util.Map,
	 * java.util.Map, java.lang.String)
	 */
	@Override
	public Map<String, Object> generate(Map<String, Object> sourceData, Map<String, Object> destData, String rule) {
		LOGGER.debug("Working on Rule : " + rule);
		initFuncs();

		Map<String, Object> resultMap = new HashMap<String, Object>();
		initFuncs();

		EnhancedContext jexlContext = new EnhancedContext(funcs);
		jexlContext.set(AppConstants.SCHEMA_TYPE_SOURCE, sourceData);
		jexlContext.set(AppConstants.SCHEMA_TYPE_TARGET, destData);

		JexlScript e = jexl.createScript(rule);
		Object obj = e.execute(jexlContext);
		resultMap.put(e.toString(), obj);
		LOGGER.debug(resultMap.toString());
		return resultMap;
	}

	@Override
	public List<Integer> getNumberSeries(String rule) {

		List<Integer> numberList = new ArrayList<Integer>();
		Map<String, Object> sourceData = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		// Dummy insertion for first run;
		
		sourceData.put("x", "1");
		
		LOGGER.debug("Working on Rule : " + rule);

		EnhancedContext jexlContext = new EnhancedContext(funcs);
		jexlContext.set(AppConstants.SCHEMA_TYPE_SOURCE, sourceData);
		JexlScript e = jexl.createScript(rule);
		Object obj = e.execute(jexlContext);

		// Get initial values from the first iteration.

		Integer firstNumber = (Integer) sourceData.get("firstNumber");
		Integer totalCount = (Integer) sourceData.get("totalCount");
		Integer step = (Integer) sourceData.get("step");

		LOGGER.debug("First Number " + firstNumber + " , Total Count " + totalCount);

		if (firstNumber != null && totalCount != null) {
			
			sourceData.put("x", firstNumber);
			
			for ( int i = 1 ; i  <= totalCount ; i++ ) {
				
				e = jexl.createScript(rule);
				obj = e.execute(jexlContext);

//				LOGGER.debug(obj.toString());
				
				numberList.add((Integer)sourceData.get("x"));
				if ( step != null ) {
					firstNumber = firstNumber + step ;
				} else {
					firstNumber = firstNumber + 1 ;
				}
				sourceData.put("x", firstNumber);
				
			}

			resultMap.put(e.toString(), obj);
			LOGGER.debug(resultMap.toString());

		}
		
		if ( numberList.size() > 0 ) {
			Catalogue cat = new Catalogue();
			cat.setDescription(rule);
			cat.setSeries(numberList.toString());
			appxService.addCatalogue(cat);
		}
		
		
		
		
		
		return numberList;
	}

	private void initFuncs() {

		if (funcs.get("fn") == null) {
			funcs.put("fn", service);
		}

	}

	public static class EnhancedContext extends JexlEvalContext {
		int factor = 6;
		final Map<String, Object> funcs;

		EnhancedContext(Map<String, Object> funcs) {
			super();
			this.funcs = funcs;
		}

		@Override
		public Object resolveNamespace(String name) {
			return funcs.get(name);
		}
	}

}
