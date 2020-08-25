package com.kk.StealMonitor.service.product;

import com.kk.StealMonitor.dao.product.ProductDao;
import com.kk.StealMonitor.dao.product.ProductDaoGet;
import com.kk.StealMonitor.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class ProductGetService {
    private ProductDao productDao;

    @Autowired
    public ProductGetService(@Qualifier("fakeProductDao") ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}
