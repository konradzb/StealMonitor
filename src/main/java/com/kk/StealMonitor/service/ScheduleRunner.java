package com.kk.StealMonitor.service;

import com.kk.StealMonitor.dao.page.PageDao;
import com.kk.StealMonitor.model.Page;
import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.product.ProductEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
/*
* This class is responsible for load all products, update and delete them
* Every site from we scratching products has its own method
* If you want add another site for scratching,
* you should make method to looks like those below
*
* Also every site has its own list in map in ProductEditService
* you can get this by putting special String into ProductEditService.getIdList(String key)
* key - it is url but without https://, eg. 'www.x-kom.pl'
* */

@Service
public class ScheduleRunner {

    private final ProductLoader productsLoader;
    private final ProductEditService productService;
    private final PageDao pageDao;
    private final List<Page> pages;

    @Autowired
    public ScheduleRunner(ProductLoader productsLoader, ProductEditService productService, @Qualifier("PostgresPage") PageDao pageDao) {
        this.productsLoader = productsLoader;
        this.productService = productService;
        this.pageDao = pageDao;
        pages = this.pageDao.getAllPages();

        // at start, make sure that product table is clear,
        // and after that load all products from all pages
        clearTableAndLoadEveryProduct();
    }
    ////** Refresh full product **////
    @Scheduled(cron = "0 0 10/12 * * ?")
    public void every12h_10and22() {
        loadProductsToDataBaseAndSafeIDs(pages.get(0), "www.x-kom.pl");
    }
    @Scheduled(cron = "0 0 14 * * ?")
    public void every24h_14() {
        loadProductsToDataBaseAndSafeIDs(pages.get(1), "www.morele.net/alarmcenowy/");
    }

    ////** Update remaining quantity **////
    @Scheduled(cron = "0/30 * * * * ?")
    public void every30s() {
        System.out.println(productService.getIdList("www.x-kom.pl"));
        updateProductsRemainingQuantityByIDs(pages.get(0), "www.x-kom.pl");
    }
    @Scheduled(cron = "0 0/3 * * * ?")
    public void every3min() {
        System.out.println(productService.getIdList("www.morele.net/alarmcenowy/"));
        updateProductsRemainingQuantityByIDs(pages.get(1), "www.morele.net/alarmcenowy/");
    }

    // at server's starts
    public int clearTableAndLoadEveryProduct() {
        productService.deleteAllProducts();
        //it should be pages.forEach(page-> loadProductsToDataBaseAndSafeIDs(pages.get(0), "xkom_hotshot"));
        //but "key" has to be given automatically, and for now it's impossible,
        //because in pageTable we don't store information about steal name
        //eg. hotshot or alarmCenowy
        //or instead of "sitename_stealname" we can use url, but without "https://"

        //loadProductsToDataBaseAndSafeIDs(pages.get(0), "xkom_hotshot");
        pages.forEach(page-> loadProductsToDataBaseAndSafeIDs(page, substringUrl(page.getUrl())));
        System.out.println(productService.getIdList("www.x-kom.pl"));
        return 1;
    }

    public int loadProductsToDataBaseAndSafeIDs(Page page, String key) {
        List<UUID> idList;
        //delete old products
         try {
             idList = productService.getIdList(key);
             productService.deleteListOfProducts(idList);
             idList.clear();
         } catch (NullPointerException ex) {
             ex.fillInStackTrace();
         }
        //load all products from given page
        List<Product> products = productsLoader.loadProducts(page.getUrl(), page.getDivClassName(), page.getScraperClassPath());
        //put them into DataBase, and safe its IDs
        idList = productService.insertListOfProducts(products);
        productService.setOrCreateIdList(key, idList);
        return 1;
    }

    //update whole products it's no needed for now
    public int updateWholeProductsByIDs(Page page, String key) {
        List<UUID> idList = null;
        //delete old products
        try {
            idList = productService.getIdList(key);
        } catch (NullPointerException ex) {
            ex.fillInStackTrace();
        }
        if(idList==null) return 0;
        //load all products from given page
        List<Product> products = productsLoader.loadProducts(page.getUrl(), page.getDivClassName(), page.getScraperClassPath());
        //update products in DB
        productService.updateListOfProducts(idList, products);
        return 1;
    }

    public int updateProductsRemainingQuantityByIDs(Page page, String key ) {
        List<Product> products = productsLoader.loadProducts(page.getUrl(), page.getDivClassName(), page.getScraperClassPath());
        try {
            List<UUID> idList = productService.getIdList(key);
            productService.updateRemainingListOfProducts(idList, products);
            return 1;
        } catch (NullPointerException ex) {
            ex.fillInStackTrace();
        }
        return 0;
    }

    public String substringUrl(String url) {
        int firstSlash = url.indexOf('/');
        url = url.substring(firstSlash+2);
        return url;
    }
}
