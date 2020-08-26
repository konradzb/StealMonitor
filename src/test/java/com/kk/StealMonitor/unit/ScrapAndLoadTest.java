package com.kk.StealMonitor.unit;

import com.kk.StealMonitor.dao.product.FakeProductDaoAccessService;
import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.PageLoader;
import com.kk.StealMonitor.service.ScheduleRunner;
import com.kk.StealMonitor.service.scrapers.ScrapModule;
import com.kk.StealMonitor.service.scrapers.Scraper;
import com.kk.StealMonitor.service.scrapers.XKomScraper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@SpringBootTest
public class ScrapAndLoadTest {

    @Autowired
    private PageLoader pageLoader;
    @MockBean
    private XKomScraper scraper;
    @Autowired
    private ScheduleRunner runner;

    @Test
    public void loadProductsTest() {
        String url = "https://www.x-kom.pl";
        String divClassName = "sc-bwzfXH sc-1bb6kqq-2 cNKcdN sc-htpNat gSgMmi";
        String scraperPath = "com.kk.StealMonitor.service.scrapers.XKomScraper";

        Mockito.when(scraper.scrap(Mockito.any())).thenReturn(new Product(UUID.randomUUID(),
                " here ",
                "",
                "name",
                "old",
                "new",
                "re",
                "limit",
                "img",
                "category"));


        List<Product> products = pageLoader.loadProducts(url, divClassName, scraperPath);

        assertEquals(products.size(), 1);
        if(products.size()>0) soutProduct(products.get(0));
    }

    @Test
    public void load_XKom_HotShot_Test() {
        assertEquals(1, runner.load_XKom_HotShot());
    }

    private void soutProduct(Product p) {
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getSiteName());
        System.out.println(p.getSiteLink());
        System.out.println(p.getNewPrice());
        System.out.println(p.getOldPrice());
        System.out.println(p.getRemainingQuantity());
        System.out.println(p.getLimitQuantity());
        System.out.println(p.getImg());
        System.out.println(p.getCategory());
    }

}
