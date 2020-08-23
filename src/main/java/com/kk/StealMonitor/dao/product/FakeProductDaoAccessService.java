package com.kk.StealMonitor.dao.product;

import com.kk.StealMonitor.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeProductDao")
public class FakeProductDaoAccessService implements ProductDaoEdit, ProductDaoGet {
    private List<Product> products = new ArrayList<>();

    @Override
    public int insertProduct(UUID id, Product newTask) {
        products.add(new Product(id,
                newTask.getName(),
                newTask.getSiteName(),
                newTask.getSiteLink(),
                newTask.getNewPrice(),
                newTask.getOldPrice(),
                newTask.getImg(),
                newTask.getRemainingQuantity(),
                newTask.getLimitQuantity(),
                newTask.getCategory()));
        return 1;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public List<Product> getProductsWithCustomSql(String sql) {
        return null;
    }

    @Override
    public Optional<Product> selectTaskById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteTask(UUID id) {
        Optional<Product> product = selectTaskById(id);
        if(product.isEmpty())
            return 0;

        products.remove(selectTaskById(id));
        return 1;
    }
}
