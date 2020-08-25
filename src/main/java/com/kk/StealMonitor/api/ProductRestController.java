package com.kk.StealMonitor.api;

import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.product.ProductGetService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductRestController {
    private ProductGetService productGetService;

    @Autowired
    public ProductRestController(ProductGetService productGetService) {
        this.productGetService = productGetService;
    }

    public List<Product> getAllProducts() {
        return productGetService.getAllProducts();
    }
}
