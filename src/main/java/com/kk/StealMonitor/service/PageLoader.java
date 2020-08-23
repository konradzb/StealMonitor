package com.kk.StealMonitor.service;

import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.scrapers.ScrapModule;
import com.kk.StealMonitor.service.scrapers.Scraper;
import com.kk.StealMonitor.service.scrapers.XKomScraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageLoader {
    private ScrapModule scrapModule;

    @Autowired
    public PageLoader(ScrapModule scrapModule) {
        this.scrapModule = scrapModule;
    }

    public List<Product> loadProducts(String url, String divClassName, String scraperClassPath){

        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        assert document!=null;
        Elements productDivs = document.getElementsByClass(divClassName);

          return productDivs.stream().map(element -> {
            Class<?> classObject;
            Scraper scraper = null;


//                Constructor<?> classConstructor = classObject.getConstructor(ScrapModule.class);
//                scraper = (Scraper) classConstructor.newInstance(scrapModule);
            try {
                classObject = Class.forName(scraperClassPath);
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

              //System.out.println(element);
              assert scraper != null;

              Product p = scraper.scrap(element);
              return p;

          }).collect(Collectors.toList());
    }
}
