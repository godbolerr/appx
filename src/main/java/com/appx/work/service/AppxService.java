/**
 * 
 */
package com.appx.work.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.appx.work.domain.Series;
import com.appx.work.domain.SeriesDefinition;
import com.appx.work.to.NumberSeriesInput;
import com.appx.work.to.NumberSeriesResult;

public interface AppxService {
	
	public SeriesDefinition addNumberSeries(SeriesDefinition numSeries);

	public SeriesDefinition updateNumberSeries(SeriesDefinition numSeries);

	public SeriesDefinition getNumberSeriesById(Long numSeriesId);

	public SeriesDefinition getNumberSeriesByName(String numSeriesName);

	public boolean deleteNumberSeries(Long numSeriesId);

	public List<SeriesDefinition> getNumberSeriesList();

	Page<SeriesDefinition> getPagedNumberSeriess(Pageable pageable);

	// Calculate number series based on the script provided.

	NumberSeriesResult getSeries(NumberSeriesInput input);
	
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
