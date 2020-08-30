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

    private final PageLoader pageLoader;
    private final ProductEditService productService;
    private final PageDao pageDao;
    private final List<Page> pages;

    @Autowired
    public ScheduleRunner(PageLoader pageLoader, ProductEditService productService, @Qualifier("fakePageDao") PageDao pageDao) {
        this.pageLoader = pageLoader;
        this.productService = productService;
        this.pageDao = pageDao;
        pages = this.pageDao.getAllPages();
    }


    //@Scheduled(cron = p)
    public int loadProductsToDataBaseAndSafeIDs(Page page, String key) {
        //load all products from given page
        List<Product> products = pageLoader.loadProducts(page.getUrl(), page.getDivClassName(), page.getScraperClassPath());
        //put them into DataBase, and safe its IDs
        List<UUID> idList = productService.insertListOfProducts(products);
        productService.setOrCreateIdList(key,idList);
        return 1;
    }
    public int updateProductsRemainingQuantityByIDs(Page page, String key ) {
        List<Product> products = pageLoader.loadProducts(page.getUrl(), page.getDivClassName(), page.getScraperClassPath());
        List<UUID> idList = productService.getIdList(key);

        if(idList.isEmpty()) return 0;
        productService.updateListOfProducts(idList, products);
        return 1;
    }
}
