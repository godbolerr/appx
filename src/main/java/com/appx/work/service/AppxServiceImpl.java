/**
 * 
 */
package com.appx.work.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.appx.work.domain.Series;
import com.appx.work.domain.SeriesDefinition;
import com.appx.work.repository.SeriesDefinitionRepository;
import com.appx.work.repository.SeriesRepository;
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
	private SeriesDefinitionRepository defnRepo;
	@Autowired
	private SeriesRepository seriesRepo;

	/**
	 * 
	 */
	public AppxServiceImpl() {
	}

	public SeriesDefinition addNumberSeries(SeriesDefinition numSeries) {
		return defnRepo.save(numSeries);
	}

	public SeriesDefinition updateNumberSeries(SeriesDefinition numSeries) {
		return defnRepo.save(numSeries);
	}

	public SeriesDefinition getNumberSeriesById(Long numSeriesId) {
		return defnRepo.findOne(numSeriesId);
	}

	public SeriesDefinition getNumberSeriesByName(String numSeriesName) {
		return null;// defnRepo.findByName(numSeriesName);
	}

	public boolean deleteNumberSeries(Long numSeriesId) {
		SeriesDefinition cat = defnRepo.getOne(numSeriesId);
		defnRepo.delete(cat);
		return true;
	}

	public List<SeriesDefinition> getNumberSeriess() {
		return defnRepo.findAll();
	}

	public Page<SeriesDefinition> getPagedNumberSeriess(Pageable pageable) {
		return defnRepo.findAll(pageable);
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

		int start = firstNumber;

		sourceData.put("x", new Integer(firstNumber));
		sourceData.put("firstNumber", new Integer(firstNumber));
		sourceData.put("totalCount", new Integer(total));
		sourceData.put("increment", new Integer(increment));
		sourceData.put("step", new Integer(step));

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
		LOGGER.debug("Rule: " + rule + " [" + sourceData + "] " + resultMap.toString());

		if (numberList.size() > 0) {
			SeriesDefinition numSeries = new SeriesDefinition();

			// numSeries.setIncrement(increment);
			// numSeries.setLevel(level);
			// numSeries.setRule(rule);
			// numSeries.setTotal(total);
			// numSeries.setStart(start);
			// numSeries.setStep(step);
			// numSeries.setSeries(numberList.toString());
			//
			defnRepo.save(numSeries);

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
	public List<SeriesDefinition> getNumberSeriesList() {

		return defnRepo.findAll();
	}

	@Override
	public List<SeriesDefinition> findByRule(String rule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeriesDefinition> findByRuleAndLevel(String rule, int level) {
		return null;// return defnRepo.findByRuleAndLevel(rule, level);
	}

	@Override
	public List<SeriesDefinition> findByStartAndStep(int start, int step) {
		return null;// return defnRepo.findByStartAndStep(start, step);
	}

	@Override
	public List<SeriesDefinition> findByLevel(int level) {
		return null;// return defnRepo.findByLevel(level);

	}

	@Override
	public List<SeriesDefinition> findByStart(int start) {
		return null;// return defnRepo.findByStart(start);
	}

	@Override
	public List<SeriesDefinition> findByTotal(int total) {
		return null;// return defnRepo.findByTotal(total);
	}

	@Override
	public String generate(SeriesDefinition definition) {

		String result = new String();

		String startNumber = definition.getStartNumber();

		Map<String, Object> sourceData = new HashMap<String, Object>();

		if (startNumber != null) {

			for (int j = 1; j <= 9; j++) {
				sourceData.put("x" + j, "");
			}

			sourceData.put("n", definition.getIncrement());

			String rule = definition.getEncodedSeries();

			String[] rArray = rule.split(",");

			StringBuffer sb = new StringBuffer();

			for (int j = 0; j < rArray.length; j++) {

				String newRule = "x" + (j + 1) + "=" + rArray[j] + ";";
				sb.append(newRule);
			}

			rule = sb.toString();
			rule = rule.replaceAll("[a-z][0-9]*", "s.$0");
			sourceData.put("x", Integer.parseInt(startNumber));
			EnhancedContext jexlContext = new EnhancedContext(funcs);
			jexlContext.set(AppConstants.SCHEMA_TYPE_SOURCE, sourceData);
			JexlScript e = jexl.createScript(rule);
			e.execute(jexlContext);
			LOGGER.debug(sourceData.toString());

			String series = "";
			for (int j = 1; j <= rArray.length; j++) {

				Integer value = (Integer) sourceData.get("x" + j);

				series = series + value + ",";
			}
			result = series.substring(0, series.lastIndexOf(","));
		}

		return result;
	}

	@Override
	public SeriesDefinition saveDefinition(SeriesDefinition defn) {
		return defnRepo.save(defn);
	}

	@Override
	public Series saveSeries(SeriesDefinition defn, Series series) {

		series.setDefintion(defn);

		seriesRepo.save(series);

		Set<Series> sset = defn.getSeries();

		if (sset != null) {
			sset.add(series);
		} else {
			sset = new HashSet<Series>();
			sset.add(series);
			defn.setSeries(sset);
		}

		defnRepo.save(defn);

		return series;

	}

	@Override
	public List<String> generate(SeriesDefinition definition, List<String> startNos) {

		List<String> generatedSeries = new ArrayList<String>();

		for (Iterator<String> iterator = startNos.iterator(); iterator.hasNext();) {
			String startNumber = (String) iterator.next();
			definition.setStartNumber(startNumber);
			generatedSeries.add(generate(definition));
		}

		return generatedSeries;
	}

	@Override
	public List<String> generate(SeriesDefinition definition, List<String> startNos, int increment) {

		List<String> generatedSeries = new ArrayList<String>();

		for (Iterator<String> iterator = startNos.iterator(); iterator.hasNext();) {
			String startNumber = (String) iterator.next();
			definition.setStartNumber(startNumber);
			definition.setIncrement(increment);
			generatedSeries.add(generate(definition));
		}

		return generatedSeries;
	}

}
