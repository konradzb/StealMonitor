package com.kk.StealMonitor.unit;

import com.kk.StealMonitor.dao.product.FakeProductDaoAccessService;
import com.kk.StealMonitor.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ProductDaoTest {

    @Autowired
    private FakeProductDaoAccessService productDao;

    @Test
    public void insertProductTest() {
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
        productDao.insertProduct(id,product);
        Product p = productDao.selectProductById(id).get();

        assertEquals(p.getId(), id);
    }
}
