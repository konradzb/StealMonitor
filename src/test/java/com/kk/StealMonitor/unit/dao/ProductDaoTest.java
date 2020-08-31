package com.kk.StealMonitor.unit.dao;

import com.kk.StealMonitor.dao.product.FakeProductDaoAccessService;
import com.kk.StealMonitor.dao.product.ProductDaoAccessService;
import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.product.ProductEditService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.Assert.*;

@SpringBootTest
public class ProductDaoTest {

    @Autowired
    private FakeProductDaoAccessService productDao;

    @Autowired
    private ProductEditService productEditService;

    @Autowired
    private ProductDaoAccessService productDaoAccessService;

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
    @Test
    public void insertProductPSQL() {

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

        assertEquals(productDaoAccessService.insertProduct(id, product), 1);
    }
    @Test
    public void getAllTasks() {
        assertNotNull(productDaoAccessService.getAllProducts());
        assertNotEquals(productDaoAccessService.getAllProducts().size(), 0);
    }
    @Test
    public void selectProductByIdPSQL() {
        UUID id = UUID.fromString("68c5db84-f41c-4156-9892-0f07b5e86192");
        assertEquals(productDaoAccessService.selectProductById(id).get().getId(), id);
    }
    @Test
    public void deleteProductPSQL() {
        UUID id = UUID.fromString("548ef04c-6422-4158-98b6-89c8c91178fc");
        int size = productDaoAccessService.getAllProducts().size();
        assertEquals(productDaoAccessService.deleteProduct(id), 1);
        assertEquals(productDaoAccessService.getAllProducts().size(), size-1);
    }
    @Test
    public void updateProductPSQL() {
        UUID id = UUID.fromString("68c5db84-f41c-4156-9892-0f07b5e86192");
        String name = "name";
        String link = "link";
        String siteName = "name";
        String oldPrice = "old";
        String newPrice = "new";
        String remainingQuantity = "50";
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

        productDaoAccessService.updateProduct(id, product);
    }
    @Test
    public void customSql() {
        String sql1 = "ORDER BY id_auto";
        String sql2 = "WHERE limit_quantity>'500' " + sql1;
        assertEquals(UUID.fromString("68c5db84-f41c-4156-9892-0f07b5e86192"), productDaoAccessService.getProductsWithCustomSql(sql2).get(0).getId());
    }
}
