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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.appx.work.common.AppConstants;
import com.appx.work.domain.Series;
import com.appx.work.domain.SeriesDefinition;
import com.appx.work.repository.SeriesDefinitionRepository;
import com.appx.work.repository.SeriesRepository;
import com.appx.work.to.SeriesDefinitionTO;
import com.appx.work.to.SeriesTO;

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
	private SeriesDefinitionRepository definitionRepo;
	@Autowired
	private SeriesRepository seriesRepo;

	/**
	 * 
	 */
	public AppxServiceImpl() {
	}

	@Override
	public Series createSeries(Series series) {

		return seriesRepo.save(series);
	}

	@Override
	public Series udpateSeries(Series series) {
		return seriesRepo.save(series);
	}

	@Override
	public Series deleteSeries(Long id) {
		Series series = seriesRepo.findOne(id);
		if (series != null) {
			seriesRepo.delete(series);
		}
		return series;
	}

	@Override
	public SeriesTO getSeries(Long id) {
		SeriesTO sto = new SeriesTO();
		Series series = seriesRepo.findOne(id);
		sto.setDefintion(new SeriesDefinitionTO());
		BeanUtils.copyProperties(series, sto);
		// BeanUtils.copyProperties(series.getDefintion().getId(),sto.getDefintion().getId());
		return sto;
	}

	@Override
	public List<SeriesTO> getAllSeries() {
		List<SeriesTO> stoList = new ArrayList<SeriesTO>();
		BeanUtils.copyProperties(seriesRepo.findAll(), stoList);
		return stoList;
	}

	@Override
	public SeriesDefinition createSeriesDefinition(SeriesDefinition defn) {
		return definitionRepo.save(defn);
	}

	@Override
	public SeriesDefinition updateSeriesDefinition(SeriesDefinition defn) {
		return definitionRepo.save(defn);
	}

	@Override
	public SeriesDefinitionTO getSeriesDefinition(Long id) {
		SeriesDefinitionTO sto = new SeriesDefinitionTO();
		BeanUtils.copyProperties(definitionRepo.findOne(id), sto);
		return sto;
	}

	@Override
	public SeriesDefinitionTO getSeriesDefinitionByName(String name) {
		SeriesDefinitionTO sto = new SeriesDefinitionTO();
		BeanUtils.copyProperties(definitionRepo.findByName(name), sto);
		return sto;
	}

	@Override
	public boolean deleteSeriesDefinition(Long id) {
		SeriesDefinition defn = definitionRepo.findOne(id);
		if (defn != null) {
			definitionRepo.delete(defn);
			return true;
		}
		return false;
	}

	@Override
	public List<SeriesDefinition> getAllSeriesDefinitions() {
		return definitionRepo.findAll();
	}

	@Override
	public Page<SeriesDefinition> getSeriesDefinitions(Pageable pageable) {
		return definitionRepo.findAll(pageable);
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
	public List<SeriesDefinition> findByRule(String rule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeriesDefinition> findByRuleAndLevel(String rule, int level) {
		return null;// return definitionRepo.findByRuleAndLevel(rule, level);
	}

	@Override
	public List<SeriesDefinition> findByStartAndStep(int start, int step) {
		return null;// return definitionRepo.findByStartAndStep(start, step);
	}

	@Override
	public List<SeriesDefinition> findByLevel(int level) {
		return null;// return definitionRepo.findByLevel(level);

	}

	@Override
	public List<SeriesDefinition> findByStart(int start) {
		return null;// return definitionRepo.findByStart(start);
	}

	@Override
	public List<SeriesDefinition> findByTotal(int total) {
		return null;// return definitionRepo.findByTotal(total);
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
			sourceData.put("x1", Integer.parseInt(startNumber));
			EnhancedContext jexlContext = new EnhancedContext(funcs);
			jexlContext.set(AppConstants.SCHEMA_TYPE_SOURCE, sourceData);
			JexlScript e = jexl.createScript(rule);
			e.execute(jexlContext);
			LOGGER.debug(rule + ": " + sourceData.toString());

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
		return definitionRepo.save(defn);
	}

	@Override
	public List<Series> saveSeries(SeriesDefinition defn, Series theSeries) {

		String sequence = theSeries.getSeries();

		List<Series> seriesList = getSeriesList(sequence, theSeries.getStart(), theSeries.getIncrement());

		Set<Series> sset = null;

		for (Iterator iterator = seriesList.iterator(); iterator.hasNext();) {
			Series series = (Series) iterator.next();

			series.setDefintionId(defn.getId());

			seriesRepo.save(series);
		}

		definitionRepo.save(defn);

		return seriesList;

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

	@Override
	public String generate(SeriesDefinition definition, String startNo, int increment) {
		definition.setStartNumber(startNo);
		definition.setIncrement(increment);
		return generate(definition);
	}

	@Override
	public List<Series> saveSeries(SeriesDefinition definition, String startNo, int increment) {

		definition.setStartNumber(startNo);
		definition.setIncrement(increment);
		String result = generate(definition);

		Series series = new Series();
		series.setStart(startNo);
		series.setSeries(result);
		series.setIncrement(increment + "");

		Long defId = definition.getId();

		definition = definitionRepo.findOne(defId);

		return saveSeries(definition, series);
	}

	@Override
	public List<Series> saveSeries(SeriesDefinition definition, String startNo) {
		return saveSeries(definition, startNo, 1);
	}

	private List<Series> getSeriesList(String sequence, String startNo, String increment) {

		List<Series> seriesList = new ArrayList<Series>();

		String[] item = sequence.split(",");

		String newSeries = "";

		String options = "";

		for (int i = 0; i < item.length; i++) {
			String answer = "";
			StringBuffer sb = new StringBuffer();
			item = sequence.split(",");
			for (int j = 0; j < item.length; j++) {
				if (i == j) {
					answer = item[j];
					item[j] = "*";
					options = answer + "," + (Integer.parseInt(answer) - 1) + "," + (Integer.parseInt(answer) + 1);
				}
				sb.append(item[j]);
				sb.append(",");
			}

			Series series = new Series();
			series.setAnswer(answer);
			series.setOptions(options);

			String newSequence = sb.toString();
			newSequence = newSequence.substring(0, newSequence.lastIndexOf(","));

			series.setSeries(newSequence);
			series.setStart(startNo);
			series.setIncrement(increment);

			seriesList.add(series);
		}

		return seriesList;

	}

}
