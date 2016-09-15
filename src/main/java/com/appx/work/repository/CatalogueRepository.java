package com.appx.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appx.work.domain.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
	
}
