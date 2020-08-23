package com.kk.StealMonitor;

import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.PageLoader;
import com.kk.StealMonitor.service.scrapers.Scraper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class StealMonitorApplicationTests {

	@Autowired
	private PageLoader pageLoader;
	@MockBean
	private Scraper scraper;

	@Test
	public void loadProductsTest() {
//		System.out.println("TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//		String url = "https://www.x-kom.pl";
//		String divClassName = "sc-bwzfXH sc-1bb6kqq-2 cNKcdN sc-htpNat gSgMmi";
//		String scraperPath = "service.scrapers.XKomScraper";
//
//		Mockito.when(scraper.scrap(Mockito.any())).thenReturn(new Product(UUID.randomUUID(),
//				"link",
//				"name",
//				"name",
//				"old",
//				"new",
//				"re",
//				"limit",
//				"img",
//				"category"));
//
//
//		List<Product> products = pageLoader.loadProducts(url, divClassName, scraperPath);
//
//		assertEquals(products.get(0).getName(), "name");
	}

	@Test
	void contextLoads() {
	}

}
