package com.kk.StealMonitor.service;

import com.kk.StealMonitor.dao.page.PageDao;
import com.kk.StealMonitor.dao.product.ProductDao;
import com.kk.StealMonitor.model.Page;
import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.product.ProductEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class ScheduleRunner {

    private final PageLoader pageLoader;
    private final ProductEditService productDaoService;
    private final PageDao pageDao;
    private final List<Page> pages;

    @Autowired
    public ScheduleRunner(PageLoader pageLoader, ProductEditService productDaoService, @Qualifier("fakePageDao") PageDao pageDao) {
        this.pageLoader = pageLoader;
        this.productDaoService = productDaoService;
        this.pageDao = pageDao;
        pages = this.pageDao.getAllPages();
    }

    //This is how will look like other schedules
    //@Scheduled(cron = p)
    public int load_XKom_HotShot() {
        Page page = pages.get(0);

        //load all xKom products
        List<Product> products = pageLoader.loadProducts(page.getUrl(), page.getDivClassName(), page.getScraperClassPath());
        //put them into DataBase
        products.forEach(product -> productDaoService.insertProduct(product.getId(), product));
        return 1;
    }




}
