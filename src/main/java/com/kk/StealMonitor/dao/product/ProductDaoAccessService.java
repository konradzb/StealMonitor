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
        final String sql = "SELECT * FROM products;";
        return returnListFromDB(sql);
    }

    @Override
    public List<Product> getProductsWithCustomSql(String sql) {
        //sql is like: "new_price < 500 AND old_price > 1000 ORDER BY old_price DESC"
        sql = "SELECT * FROM products " + sql + ";";
        return returnListFromDB(sql);
    }

    @Override
    public Optional<Product> selectProductById(UUID id) {
        final String sql = "SELECT * FROM products WHERE id='"+id+"'";
        return returnListFromDB(sql).stream().findFirst();
    }

    @Override
    public int deleteProduct(UUID id) {
        final String sql = "DELETE FROM products WHERE id='"+id+"'";
        return jdbcTemplate.update(sql);
    }

    @Override
    public int deleteAllProducts() {
        final String sql = "DELETE FROM products;";
        return jdbcTemplate.update(sql);
    }

    @Override
    public int updateProductRemainingQuantity(UUID id, Product product) {
        final String sql = "UPDATE products SET remaining_quantity = '" + product.getRemainingQuantity() +
                "' WHERE id = '"+ id +"';";
        return jdbcTemplate.update(sql);
    }

    @Override
    public int updateProduct(UUID id, Product product) {
        final String sql = "UPDATE products SET name=?, " +
                "site_name= ?, " +
                "site_link= ?, " +
                "old_price= ?, " +
                "new_price= ?, " +
                "remaining_quantity= ?, " +
                "limit_quantity= ?, " +
                "img_string= ?, " +
                "category= ? " +
                "WHERE id = ?;";
        return jdbcTemplate.update(sql,
                product.getName(),
                product.getSiteName(),
                product.getSiteLink(),
                product.getOldPrice(),
                product.getNewPrice(),
                product.getRemainingQuantity(),
                product.getLimitQuantity(),
                product.getImg(),
                product.getCategory(),
                id);
    }

    private List<Product> returnListFromDB(String sql) {
        return jdbcTemplate.query(sql, ((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            int idAuto = Integer.parseInt(resultSet.getString("id_auto"));
            String name = resultSet.getString("name");
            String siteName = resultSet.getString("site_name");
            String siteLink = resultSet.getString("site_link");
            String oldPrice = resultSet.getString("old_price");
            String newPrice = resultSet.getString("new_price");
            String remainingQuantity = resultSet.getString("remaining_quantity");
            String limitQuantity = resultSet.getString("limit_quantity");
            String img = resultSet.getString("img_string");
            String category = resultSet.getString("category");

            return new Product(id, idAuto, name, siteName, siteLink, oldPrice, newPrice, remainingQuantity, limitQuantity, img, category);
        }));
    }
}
