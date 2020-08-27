package com.kk.StealMonitor.service.product;

import com.google.common.base.Strings;
import com.kk.StealMonitor.dao.product.ProductDao;
import com.kk.StealMonitor.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductEditService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    public ProductEditService(@Qualifier("fakeProductDao") ProductDao productDao) {
        this.productDao = productDao;
    }

    public int insertProduct(UUID id, Product newTask) {
        if(Strings.isNullOrEmpty(newTask.getName())
        || Strings.isNullOrEmpty(newTask.getSiteName())
        || Strings.isNullOrEmpty(newTask.getSiteLink())
        || Strings.isNullOrEmpty(newTask.getOldPrice())
        || Strings.isNullOrEmpty(newTask.getNewPrice())
        || Strings.isNullOrEmpty(newTask.getRemainingQuantity())
        || Strings.isNullOrEmpty(newTask.getLimitQuantity())
        || Strings.isNullOrEmpty(newTask.getImg())) {
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
