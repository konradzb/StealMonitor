package com.kk.StealMonitor.dao.product;

import com.kk.StealMonitor.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {

    int insertProduct(UUID id, Product newTask);

    default int insertProduct(Product newTask) {
        insertProduct(UUID.randomUUID(), newTask);
        return 1;
    }

    List<Product> getAllProducts();

    List<Product> getProductsWithCustomSql(String sql);

    Optional<Product> selectTaskById(UUID id);

    int deleteTask(UUID id);
}
