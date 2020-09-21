package com.kk.StealMonitor.service.scrapers;

import com.kk.StealMonitor.model.Product;
import org.jsoup.nodes.Element;

import java.util.UUID;

public class MoreleScraper implements Scraper {
    private ScrapModule scrapModule;

    public MoreleScraper(ScrapModule scrapModule) {
        this.scrapModule = scrapModule;
    }
    // INSERT INTO pages (id, url, div_class_name, scraper_class_path, update_time, get_time)VALUES ('c1ce5488-2435-4801-99fd-b915a1b35a5a', 'https://www.morele.net/alarmcenowy/', 'item','com.kk.StealMonitor.service.scrapers.MoreleScraper', '0 0/3 * * * ?', '0 0 14 * * ?');
    @Override
    public Product scrap(Element element) {
        return new Product(UUID.randomUUID(),
                "Smartfon Apple iPhone 11 64 GB Dual SIM Zielony (MWLY2PM/A)",
                "morele.net",
                "https://www.morele.net/alarmcenowy/",
                "3269 zł",
                "3159 zł",
                "1",
                "1",
                "https://images.morele.net/i256/6297964_0_i256.jpg",
                "smartphone");
    }
}
