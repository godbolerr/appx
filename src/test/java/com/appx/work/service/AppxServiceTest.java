package com.appx.work.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appx.work.config.RootConfig;
import com.appx.work.domain.Catalogue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RootConfig.class)
public class AppxServiceTest {

	@Autowired
	AppxService service;

	@Test
	public void testAddCatalogue() {
		Catalogue cat = new Catalogue();
		cat.setName("firstNamenew");
		cat.setDescription("firstDescription");
		cat = service.addCatalogue(cat);
		assertTrue(cat.getId() > 0);
	}

	@Test
	public void testUpdateCatalogue() {
		Catalogue cat = new Catalogue();
		cat.setName("firstNameUpdated");
		cat.setDescription("firstDescription");
		cat = service.addCatalogue(cat);
		assertTrue(cat.getId() > 0);
	}

	@Test
	public void testGetCatalogueById() {
		Catalogue cat = new Catalogue();
		cat.setName("firstName");
		cat.setDescription("firstDescription");
		cat = service.addCatalogue(cat);
		assertTrue(cat.getId() > 0);

		Long id = cat.getId();

		Catalogue newcat = service.getCatalogueById(id);

		assertTrue(newcat != null);

	}

	@Test
	public void testGetCatalogueByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCatalogue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCatalogues() {

		Catalogue cat = new Catalogue();
		cat.setName("firstName");
		cat.setDescription("firstDescription");
		cat = service.addCatalogue(cat);

		Catalogue catNew = new Catalogue();
		catNew.setName("firstName");
		catNew.setDescription("firstDescription");
		service.addCatalogue(catNew);

		List<Catalogue> list = service.getCatalogues();

		assertTrue(list.size() > 0);

	}

	@Test
	public void testGetPagedCatalogues() {
		fail("Not yet implemented");
	}

}
