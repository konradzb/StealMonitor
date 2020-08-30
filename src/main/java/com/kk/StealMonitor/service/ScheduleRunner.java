package com.kk.StealMonitor.service;

import com.kk.StealMonitor.dao.page.PageDao;
import com.kk.StealMonitor.model.Page;
import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.product.ProductEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
* key - goes like this "siteName_promotionName", eg. "XKom_hotShot", "Morele_AlarmCenowy"
* it doesn't matter if you type Upper or lower case
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
        productService.setOrCreateIdList(key,idList);
        return 1;
    }

    public int updateProductsRemainingQuantityByIDs(Page page, String key ) {
        List<Product> products = productsLoader.loadProducts(page.getUrl(), page.getDivClassName(), page.getScraperClassPath());
        try {
            List<UUID> idList = productService.getIdList(key);
            productService.updateListOfProducts(idList, products);
            return 1;
        } catch (NullPointerException ex) {
            ex.fillInStackTrace();
        }
        return 0;
    }
}
