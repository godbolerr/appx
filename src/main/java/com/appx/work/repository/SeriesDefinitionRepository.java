package com.appx.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appx.work.domain.SeriesDefinition;

public interface SeriesDefinitionRepository extends JpaRepository<SeriesDefinition, Long> {
	
	SeriesDefinition findByName(String name);
}
