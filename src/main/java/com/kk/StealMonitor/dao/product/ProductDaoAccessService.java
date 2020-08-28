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
        final String sql = "INSERT INTO products (id, name, site_name, site_link, old_price, new_price, remaining_quantity, limit_quantity, img_string, category) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, id,
                product.getName(),
                product.getSiteName(),
                product.getSiteLink(),
                product.getNewPrice(),
                product.getOldPrice(),
                product.getImg(),
                product.getRemainingQuantity(),
                product.getLimitQuantity(),
                product.getCategory());
    }

    @Override
    public List<Product> getAllProducts() {
        //final
        return null;
    }

    @Override
    public List<Product> getProductsWithCustomSql(String sql) {
        return null;
    }

    @Override
    public Optional<Product> selectProductById(UUID id) {
        //return getAllProducts().stream().filter(product -> product.getId().equals(id)).findFirst();
        final String sql = "SELECT * FROM products WHERE id="+id;
        jdbcTemplate.update(sql);
        return Optional.empty();
    }

    @Override
    public int deleteTask(UUID id) {
        return 0;
    }
}
