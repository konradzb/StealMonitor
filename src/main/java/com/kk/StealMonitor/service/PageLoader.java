package com.kk.StealMonitor.service;
import com.kk.StealMonitor.model.Product;
//import com.kk.StealMonitor.service.scrapers.Scraper;
//import com.kk.StealMonitor.service.scrapers.XKomScraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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

    public List<Product> loadProducts(String url, String divClassName, String scraperClassPath){

//        List<Product> products = new ArrayList<>();
        Document document = null;

        try {
            document = Jsoup.connect(url).get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        assert document!=null;
        Elements productDivs = document.getElementsByClass(divClassName);

//        return productDivs.stream().map(element -> {
//            Class<?> c = null;
//            Scraper scraper = null;
//
//            try {
//                c = Class.forName(scraperClassPath);
//                Constructor<?> cons = c.getConstructor();
//                //TEMPORARY XKOMSCRAPER
//                scraper = (XKomScraper) cons.newInstance();
//            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//            System.out.println(element);
//            assert scraper != null;
//            return scraper.scrap(element);
//
//        }).collect(Collectors.toList());
//
////        for (Element element : productDivs) {
//
//            Class<?> c = Class.forName(scraperClassPath);
//            Constructor<?> cons = c.getConstructor(Element.class);
//            scraper = (Scraper) cons.newInstance(element);
//
//            scraper.scrap(element);
//        }
//        return products;
        return null;
    }
}