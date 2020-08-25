package com.kk.StealMonitor.service.product;

import com.google.common.base.Strings;
import com.kk.StealMonitor.dao.product.ProductDao;
import com.kk.StealMonitor.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductEditService {

    private ProductDao productDao;

    @Autowired
    public ProductEditService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public int insertProduct(UUID id, Product newTask) {
        // do sprawdzenia
        if(Strings.isNullOrEmpty(newTask.getName())
        || Strings.isNullOrEmpty(newTask.getSiteName())) {
            return 0;
        }
        return productDao.insertProduct(id, newTask);

    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public List<Product> getProductsWithCustomSql(String sql) {
        return productDao.getProductsWithCustomSql(sql);
    }

    public Optional<Product> selectTaskById(UUID id) {
        return productDao.selectTaskById(id);
    }

    public int deleteTask(UUID id) {
        return productDao.deleteTask(id);
    }

}
