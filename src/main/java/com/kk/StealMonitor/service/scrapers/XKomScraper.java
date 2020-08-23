package com.kk.StealMonitor.service.scrapers;

import com.kk.StealMonitor.model.Product;
import org.jsoup.nodes.Element;

import java.util.UUID;

public class XKomScraper implements Scraper {

    @Override
    public Product scrap(Element element) {

        return new Product(UUID.randomUUID(),
                "link",
                "name",
                "name",
                "old",
                "new",
                "re",
                "limit",
                "img",
                "category");

    }
}
