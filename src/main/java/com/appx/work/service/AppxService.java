/**
 * 
 */
package com.appx.work.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.appx.work.domain.Catalogue;

public interface AppxService {
	public Catalogue addCatalogue(Catalogue catalogue);
	public Catalogue updateCatalogue(Catalogue catalogue);
	public Catalogue getCatalogueById(Long catalogueId);
	public Catalogue getCatalogueByName(String catalogueName);
	public boolean deleteCatalogue(Long catalogueId);
	public List<Catalogue> getCatalogues();
	Page<Catalogue> getPagedCatalogues(Pageable pageable);

}
