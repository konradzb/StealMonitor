package com.kk.StealMonitor.service;

import com.kk.StealMonitor.dao.page.PageDao;
import com.kk.StealMonitor.dao.product.ProductDao;
import com.kk.StealMonitor.model.Page;
import com.kk.StealMonitor.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class ScheduleRunner {

    private final PageLoader pageLoader;
    private final ProductDao productDao;
    private final PageDao pageDao;

    @Autowired
    public ScheduleRunner(PageLoader pageLoader, @Qualifier("fakeProductDao") ProductDao productDao, @Qualifier("fakePageDao") PageDao pageDao) {
        this.pageLoader = pageLoader;
        this.productDao = productDao;
        this.pageDao = pageDao;
    }

    //This is how will look like other schedules
    public int load_XKom_HotShot() {
        Page page = pageDao.getAllPages().get(0);
        List<Product> products = pageLoader.loadProducts(page.getUrl(), page.getDivClassName(), page.getScraperClassPath());
        products.forEach(productDao::insertProduct);
        return 1;
    }




}
