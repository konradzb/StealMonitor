package com.kk.StealMonitor.dao.product;

import com.kk.StealMonitor.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeProductDao")
public class FakeProductDaoAccessService implements ProductDao {
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
        //just for test
        UUID id = UUID.randomUUID();
        String name = "name";
        String link = "link";
        String siteName = "name";
        String oldPrice = "old";
        String newPrice = "new";
        String remainingQuantity = "re";
        String limitQuantity = "limit";
        String img = "img";
        String category = "category";

        Product product = new Product(id,
                link,
                name,
                siteName,
                oldPrice,
                newPrice,
                remainingQuantity,
                limitQuantity,
                img,
                category);
        insertProduct(id,product);

        return products;
    }

    @Override
    public List<Product> getProductsWithCustomSql(String sql) {
        //this won't be working in fakeProductDao
        return null;
    }

    @Override
    public Optional<Product> selectProductById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteTask(UUID id) {
        Optional<Product> product = selectProductById(id);
        if(product.isEmpty())
            return 0;
        products.remove(product);
        return 1;
    }
}
