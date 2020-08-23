package com.kk.StealMonitor.service.scrapers;

import com.kk.StealMonitor.model.Product;
import org.jsoup.nodes.Element;

public interface Scraper {
    Product scrap(Element element);

}
