package com.kk.StealMonitor.service.scrapers;

import com.kk.StealMonitor.model.Product;
import org.jsoup.nodes.Element;

import java.util.UUID;

public class XKomScraper implements Scraper {
    private ScrapModule scrapModule;

    public XKomScraper(ScrapModule scrapModule) {
        this.scrapModule = scrapModule;
    }

    @Override
    public Product scrap(Element element) {

        return new Product(UUID.randomUUID(),
                "KIOXIA 500GB M.2 PCIe NVMe EXCERIA",
                "xKom.com",
                "https://www.x-kom.pl/",
                "299,00 zł",
                "249,00 zł",
                "46",
                "200",
                "https://cdn.x-kom.pl/i/img/promotions/hot-shot-large,,hs_2020_9_21_9_8_35.PNG",
                "brak");
    }
}