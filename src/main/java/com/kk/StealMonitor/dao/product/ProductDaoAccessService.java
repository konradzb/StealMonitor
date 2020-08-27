package com.kk.StealMonitor.dao.product;

import com.kk.StealMonitor.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PostgresProduct")
public class ProductDaoAccessService implements ProductDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertProduct(UUID id, Product product) {
        return 0;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getProductsWithCustomSql(String sql) {
        return null;
    }

    @Override
    public Optional<Product> selectProductById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteTask(UUID id) {
        return 0;
    }
}
