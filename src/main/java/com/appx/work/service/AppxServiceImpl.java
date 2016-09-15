/**
 * 
 */
package com.appx.work.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.appx.work.domain.Catalogue;

/**
 * @author 115750
 *
 */
@Service
public class AppxServiceImpl implements AppxService {

	/**
	 * 
	 */
	public AppxServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Catalogue addCatalogue(Catalogue catalogue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogue updateCatalogue(Catalogue catalogue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogue getCatalogueById(Long catalogueId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogue getCatalogueByName(String catalogueName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCatalogue(Long catalogueId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Catalogue> getCatalogues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Catalogue> getPagedCatalogues(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.appx.work.service.AppxService#createEntity(java.lang.String)
	 */
	
}
