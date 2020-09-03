package com.kk.StealMonitor.service.scrapers;

import com.kk.StealMonitor.model.Product;
import org.jsoup.nodes.Element;

import java.util.UUID;

public class MoreleScraper implements Scraper {
    private ScrapModule scrapModule;

    public MoreleScraper(ScrapModule scrapModule) {
        this.scrapModule = scrapModule;
    }

    @Override
    public Product scrap(Element element) {
        return new Product(UUID.randomUUID(),
                "xkom product",
                "UPDATE - name",
                "name",
                "old",
                "new",
                "9999",
                "limit",
                "img",
                "category");
    }
}
