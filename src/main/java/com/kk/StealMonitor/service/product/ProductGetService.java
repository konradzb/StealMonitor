package com.kk.StealMonitor.service.product;

import com.kk.StealMonitor.dao.product.ProductDao;
import com.kk.StealMonitor.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductGetService {
    private ProductDao productDao;

    @Autowired
    public ProductGetService(@Qualifier("PostgresProduct") ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public List<Product> getProductsWithCustomSql(String sql) {
        return productDao.getProductsWithCustomSql(sql);
    }

    public Optional<Product> selectProductById(UUID id) {
        return productDao.selectProductById(id);
    }
}
