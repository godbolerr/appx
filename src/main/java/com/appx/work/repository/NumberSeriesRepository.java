package com.appx.work.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appx.work.domain.NumberSeries;

public interface NumberSeriesRepository extends JpaRepository<NumberSeries, Long> {
	
	List<NumberSeries> findByRule(String rule);
	
	List<NumberSeries> findByRuleAndLevel(String rule,int level);
	
	List<NumberSeries> findByStartAndStep(int start,int step);
	
	List<NumberSeries> findByLevel(int level);
	
	List<NumberSeries> findByStart(int start);
	
	List<NumberSeries> findByTotal(int total);
	
	// Get max id 
	
	// Get rule like.
	
}
