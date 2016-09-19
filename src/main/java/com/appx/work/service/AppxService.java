/**
 * 
 */
package com.appx.work.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.appx.work.domain.Series;
import com.appx.work.domain.SeriesDefinition;
import com.appx.work.to.SeriesDefinitionTO;
import com.appx.work.to.SeriesTO;

public interface AppxService {
	
	
	// Series specific operations.
	
	Series createSeries(Series series);
	
	Series udpateSeries(Series series);
	
	Series deleteSeries(Long id);

	SeriesTO getSeries(Long id);
	
	 List<SeriesTO> getAllSeries();
	 
	 public SeriesDefinition createSeriesDefinition(SeriesDefinition defn);

	public SeriesDefinition updateSeriesDefinition(SeriesDefinition defn);

	public SeriesDefinitionTO getSeriesDefinition(Long id);

	public SeriesDefinitionTO getSeriesDefinitionByName(String name);

	public boolean deleteSeriesDefinition(Long id);

	public List<SeriesDefinition> getAllSeriesDefinitions();

	Page<SeriesDefinition> getSeriesDefinitions(Pageable pageable);
	
	
	public String generate(SeriesDefinition definition);
	
	public List<String> generate(SeriesDefinition definition,List<String> startNos);
	
	public String generate(SeriesDefinition definition,String startNo,int increment);
	
	public List<String> generate(SeriesDefinition definition,List<String> startNos,int increment);
	
	public List<Series> saveSeries(SeriesDefinition definition,String startNo);
	
	public List<Series> saveSeries(SeriesDefinition definition,String startNo,int increment);
	
	// Finder methods
	
	List<SeriesDefinition> findByRule(String rule);
	
	List<SeriesDefinition> findByRuleAndLevel(String rule,int level);
	
	List<SeriesDefinition> findByStartAndStep(int start,int step);
	
	List<SeriesDefinition> findByLevel(int level);
	
	List<SeriesDefinition> findByStart(int start);
	
	List<SeriesDefinition> findByTotal(int total);
	
	SeriesDefinition saveDefinition(SeriesDefinition defn);
	
	List<Series> saveSeries(SeriesDefinition defn,Series series);
	
	
	

}
