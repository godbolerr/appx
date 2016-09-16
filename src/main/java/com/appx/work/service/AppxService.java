/**
 * 
 */
package com.appx.work.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.appx.work.domain.NumberSeries;
import com.appx.work.to.NumberSeriesInput;
import com.appx.work.to.NumberSeriesResult;

public interface AppxService {
	
	public NumberSeries addNumberSeries(NumberSeries numSeries);

	public NumberSeries updateNumberSeries(NumberSeries numSeries);

	public NumberSeries getNumberSeriesById(Long numSeriesId);

	public NumberSeries getNumberSeriesByName(String numSeriesName);

	public boolean deleteNumberSeries(Long numSeriesId);

	public List<NumberSeries> getNumberSeriesList();

	Page<NumberSeries> getPagedNumberSeriess(Pageable pageable);

	// Calculate number series based on the script provided.

	NumberSeriesResult getSeries(NumberSeriesInput input);
	
	public List<Integer> generateSeries(int start,int step,int increment,int total, int level, String rule);
	
	// Finder methods
	
	List<NumberSeries> findByRule(String rule);
	
	List<NumberSeries> findByRuleAndLevel(String rule,int level);
	
	List<NumberSeries> findByStartAndStep(int start,int step);
	
	List<NumberSeries> findByLevel(int level);
	
	List<NumberSeries> findByStart(int start);
	
	List<NumberSeries> findByTotal(int total);
	
	
	

}
