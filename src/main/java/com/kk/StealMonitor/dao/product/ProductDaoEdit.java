package com.kk.StealMonitor.dao.product;

import com.kk.StealMonitor.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductDaoEdit {
    int insertProduct(UUID id, Product newTask);

    Optional<Product> selectTaskById(UUID id);

    int deleteTask(UUID id);
}
