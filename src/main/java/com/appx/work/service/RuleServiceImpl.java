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
import com.appx.work.domain.SeriesDefinition;

/**
 * @author 115750
 *
 */
@Service
public abstract class RuleServiceImpl implements RuleService {

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
