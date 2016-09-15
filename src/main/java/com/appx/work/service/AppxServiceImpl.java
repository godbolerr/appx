/**
 * 
 */
package com.appx.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.appx.work.domain.Catalogue;
import com.appx.work.repository.CatalogueRepository;
import com.appx.work.to.NumberSeriesInput;
import com.appx.work.to.NumberSeriesResult;

/**
 * @author 115750
 *
 */
@Service
public class AppxServiceImpl implements AppxService {

	@Autowired
	private CatalogueRepository catRepo;

	/**
	 * 
	 */
	public AppxServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Catalogue addCatalogue(Catalogue catalogue) {
		return catRepo.save(catalogue);
	}

	@Override
	public Catalogue updateCatalogue(Catalogue catalogue) {
		return catRepo.save(catalogue);
	}

	@Override
	public Catalogue getCatalogueById(Long catalogueId) {
		return catRepo.findOne(catalogueId);
	}

	@Override
	public Catalogue getCatalogueByName(String catalogueName) {
		return catRepo.findByName(catalogueName);
	}

	@Override
	public boolean deleteCatalogue(Long catalogueId) {
		Catalogue cat = catRepo.getOne(catalogueId);
		catRepo.delete(cat);
		return true;
	}

	@Override
	public List<Catalogue> getCatalogues() {
		return catRepo.findAll();
	}

	@Override
	public Page<Catalogue> getPagedCatalogues(Pageable pageable) {
		return catRepo.findAll(pageable);
	}

	@Override
	public NumberSeriesResult getSeries(NumberSeriesInput input) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}
}
