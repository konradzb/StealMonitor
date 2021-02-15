package com.kk.StealMonitor.dao.product;

import com.kk.StealMonitor.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDaoGet {
    List<Product> getAllProducts();

    List<Product> getProductsWithCustomSql(String sql);

    Optional<Product> selectTaskById(UUID id);
}
