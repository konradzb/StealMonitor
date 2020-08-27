package com.kk.StealMonitor.unit.model;

import com.kk.StealMonitor.model.Page;
import com.kk.StealMonitor.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.Assert.*;

public class ModelTests {

    @Test
    public void productTest() {
        UUID id = UUID.randomUUID();
        String name = null;
        String siteName = "";
        String link = "link";
        String oldPrice = "old";
        String newPrice = "new";
        String remainingQuantity = "re";
        String limiQuantity = "limit";
        String img = "img";
        String category = "category";

        Product p = new Product(id,
                name,
                siteName,
                link,
                oldPrice,
                newPrice,
                remainingQuantity,
                limiQuantity,
                img,
                category);

        assertEquals(p.getId(), id);
        assertEquals(p.getName(), name);
        assertEquals(p.getSiteName(), siteName);
        assertEquals(p.getSiteLink(), link);
        assertEquals(p.getOldPrice(), oldPrice);
        assertEquals(p.getNewPrice(), newPrice);
        assertEquals(p.getRemainingQuantity(), remainingQuantity);
        assertEquals(p.getLimitQuantity(), limiQuantity);
        assertEquals(p.getImg(), img);
        assertEquals(p.getCategory(), category);

    }
    @Test
    public void PageTest() {
        UUID id = UUID.randomUUID();
        String url = "url";
        String divClassName = "class name";
        String scraperClassPath = "scraper path";
        String refreshTime = "time refresh";
        String hoursBetween = "hours between";

        Page p = new Page(id, url, divClassName, scraperClassPath, refreshTime ,hoursBetween);

        assertEquals(p.getId(), id);
        assertEquals(p.getDivClassName(), divClassName);
        assertEquals(p.getScraperClassPath(), scraperClassPath);
        assertEquals(p.getRefreshTime(), refreshTime);
        assertEquals(p.getHoursBetween(), hoursBetween);
    }
}
