package com.kk.StealMonitor.api;

import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.ProductGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
public class ProductRestController {
    private ProductGetService productGetService;

    @Autowired
    public ProductRestController(ProductGetService productGetService) {
        this.productGetService = productGetService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productGetService.getAllProducts();
    }

    @GetMapping("{sql}")
    public List<Product> getProductsWithCustomSql(@PathVariable("sql") String sql) {
        return productGetService.getProductsWithCustomSql(sql);
    }

    @GetMapping("select/{id}")
    public Optional<Product> selectById(@PathVariable("id") UUID id) {
        return productGetService.selectProductById(id);
    }
}
