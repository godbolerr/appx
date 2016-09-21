package com.appx.work.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appx.work.domain.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {
	
	List<Series> findByDefintionIdAndLevel(Long definitionId,int level);
}
