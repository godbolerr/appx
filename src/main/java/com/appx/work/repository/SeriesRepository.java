package com.appx.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appx.work.domain.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
