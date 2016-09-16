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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.appx.work.common.AppConstants;
import com.appx.work.domain.NumberSeries;
import com.appx.work.repository.NumberSeriesRepository;
import com.appx.work.to.NumberSeriesInput;
import com.appx.work.to.NumberSeriesResult;

/**
 * @author 115750
 *
 */
@Service
public class AppxServiceImpl implements AppxService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppxServiceImpl.class);

	java.util.Map<String, Object> funcs = new java.util.HashMap<String, Object>();

	JexlEngine jexl = new JexlBuilder().cache(512).strict(true).silent(false).create();

	@Autowired
	private NumberSeriesRepository numSeriesRepo;

	/**
	 * 
	 */
	public AppxServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public NumberSeries addNumberSeries(NumberSeries numSeries) {
		return numSeriesRepo.save(numSeries);
	}

	public NumberSeries updateNumberSeries(NumberSeries numSeries) {
		return numSeriesRepo.save(numSeries);
	}

	public NumberSeries getNumberSeriesById(Long numSeriesId) {
		return numSeriesRepo.findOne(numSeriesId);
	}

	public NumberSeries getNumberSeriesByName(String numSeriesName) {
		return null;// numSeriesRepo.findByName(numSeriesName);
	}

	public boolean deleteNumberSeries(Long numSeriesId) {
		NumberSeries cat = numSeriesRepo.getOne(numSeriesId);
		numSeriesRepo.delete(cat);
		return true;
	}

	public List<NumberSeries> getNumberSeriess() {
		return numSeriesRepo.findAll();
	}

	public Page<NumberSeries> getPagedNumberSeriess(Pageable pageable) {
		return numSeriesRepo.findAll(pageable);
	}

	public NumberSeriesResult getSeries(NumberSeriesInput input) {

		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> generateSeries(int firstNumber, int step, int increment, int total, int level, String rule) {

		List<Integer> numberList = new ArrayList<Integer>();
		Map<String, Object> sourceData = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		// Dummy insertion for first run;

		sourceData.put("x", new Integer(firstNumber));
		sourceData.put("firstNumber", new Integer(firstNumber));
		sourceData.put("totalCount", new Integer(total));
		sourceData.put("increment", new Integer(increment));
		sourceData.put("step", new Integer(step));

		LOGGER.debug("Rule: " + rule + "[" + sourceData + "]");

		Object obj = null;

		EnhancedContext jexlContext = new EnhancedContext(funcs);
		jexlContext.set(AppConstants.SCHEMA_TYPE_SOURCE, sourceData);
		JexlScript e = jexl.createScript(rule);

		for (int i = 1; i <= total; i++) {

			obj = e.execute(jexlContext);

			numberList.add((Integer) sourceData.get("x"));
			if (step != 0) {
				firstNumber = firstNumber + step;
			} else {
				firstNumber = firstNumber + 1;
			}
			sourceData.put("x", firstNumber);
		}

		resultMap.put(e.toString(), obj);
		LOGGER.debug(resultMap.toString());

		if (numberList.size() > 0) {
			NumberSeries numSeries = new NumberSeries();

			numSeries.setIncrement(increment);
			numSeries.setLevel(level);
			numSeries.setRule(rule);
			numSeries.setTotal(total);
			numSeries.setStart(firstNumber);
			numSeries.setStep(step);
			numSeries.setSeries(numberList.toString());

			numSeriesRepo.save(numSeries);

		}

		return numberList;
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

	@Override
	public List<NumberSeries> getNumberSeriesList() {
		
		return numSeriesRepo.findAll();
	}

}
