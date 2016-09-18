/**
 * 
 */
package com.appx.work.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.appx.work.domain.Series;
import com.appx.work.domain.SeriesDefinition;

public interface AppxService {
	
	
	// Series specific operations.
	
	Series createSeries(Series series);
	
	Series udpateSeries(Series series);
	
	Series deleteSeries(Long id);

	Series getSeries(Long id);
	
	 List<Series> getAllSeries();
	 
	 public SeriesDefinition createSeriesDefinition(SeriesDefinition defn);

	public SeriesDefinition updateSeriesDefinition(SeriesDefinition defn);

	public SeriesDefinition getSeriesDefinition(Long id);

	public SeriesDefinition getSeriesDefinitionByName(String name);

	public boolean deleteSeriesDefinition(Long id);

	public List<SeriesDefinition> getAllSeriesDefinitions();

	Page<SeriesDefinition> getSeriesDefinitions(Pageable pageable);
	
	public List<Integer> generateSeries(int start,int step,int increment,int total, int level, String rule);
	
	public String generate(SeriesDefinition definition);
	
	public List<String> generate(SeriesDefinition definition,List<String> startNos);
	
	public String generate(SeriesDefinition definition,String startNo,int increment);
	
	public List<String> generate(SeriesDefinition definition,List<String> startNos,int increment);
	
	public Series saveSeries(SeriesDefinition definition,String startNo);
	
	public Series saveSeries(SeriesDefinition definition,String startNo,int increment);
	
	// Finder methods
	
	List<SeriesDefinition> findByRule(String rule);
	
	List<SeriesDefinition> findByRuleAndLevel(String rule,int level);
	
	List<SeriesDefinition> findByStartAndStep(int start,int step);
	
	List<SeriesDefinition> findByLevel(int level);
	
	List<SeriesDefinition> findByStart(int start);
	
	List<SeriesDefinition> findByTotal(int total);
	
	SeriesDefinition saveDefinition(SeriesDefinition defn);
	
	Series saveSeries(SeriesDefinition defn,Series series);
	
	
	

}
