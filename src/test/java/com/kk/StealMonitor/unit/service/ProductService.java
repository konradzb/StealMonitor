package com.kk.StealMonitor.unit.service;

import com.kk.StealMonitor.dao.product.ProductDao;
import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.product.ProductEditService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@SpringBootTest
public class ProductService {

    @Autowired
    private ProductEditService productEditService;

//    @MockBean("P")
//    private ProductDao productDao;

    @Test
    public void insertProductService() {
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

       //Mockito.when(productDao.insertProduct(id, product)).thenReturn(1);
        assertEquals(productEditService.insertProduct(id, product), 1);
    }
    @Test
    public void setGetCreateIdsListTest() {
        List<UUID> idList = new ArrayList<>(Arrays.asList(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID()
        ));
        String key = "site_promo";

        //create and get
        assertEquals(productEditService.setOrCreateIdList(key, idList), 1);
        assertEquals(productEditService.getIdList(key), idList);
        assertEquals(productEditService.getIdList(key).size(), idList.size());
        System.out.println(idList.size());

        //set and get
        idList.add(UUID.randomUUID());
        assertEquals(productEditService.setOrCreateIdList(key, idList), 1);
        assertEquals(productEditService.getIdList(key), idList);
        assertEquals(productEditService.getIdList(key).size(), idList.size());
        System.out.println(idList.size());
    }
    @Test
    public void updateListOfProducts() {
        //four IDs
        List<UUID> idList = new ArrayList<>(Arrays.asList(
                UUID.fromString("ebc9d6a4-7fbf-46fa-b211-f63815168f74"),
                UUID.fromString("320ec070-10b1-48f8-b025-0103be710ffd"),
                UUID.fromString("782fa261-9603-474d-bfe0-10f126df34ae"),
                UUID.fromString("12cd8ff3-c605-4a56-bbec-2c2d0b08d868")

        ));
        UUID id = UUID.randomUUID();
        String name = "name";
        String link = "link";
        String siteName = "name";
        String oldPrice = "old";
        String newPrice = "new";
        String remainingQuantity = "0000";
        String limitQuantity = "limit";
        String img = "img";
        String category = "category";

        //three products
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
        List<Product> products = new ArrayList<>(Arrays.asList(new Product(id, link, name, siteName, oldPrice, newPrice, remainingQuantity, limitQuantity, img, category),
                new Product(id, link, name, siteName, oldPrice, newPrice, remainingQuantity, limitQuantity, img, category),
                new Product(id, link, name, siteName, oldPrice, newPrice, remainingQuantity, limitQuantity, img, category)));

        //it shouldn't work
        assertEquals(productEditService.updateListOfProducts(idList, products), 0);
    }
//    @Test
//    public void crypt() {
//        String sql = "WHERE limit_quantity>'500' ORDER BY id_auto";
//        String a = "1234567890qwertyuiopasdfghjklzxcvbnm";
//        int size = sql.length();
//        int aLength = a.length();
//        System.out.println(aLength);
//        double[] bytes = new double[size];
//
//        for (int i = 0; i < size; i++) {
//            char singleChar = sql.charAt(i);
//            int singleCharASCII = singleChar;
//            //System.out.println(singleCharASCII);
//
//            int k = singleCharASCII;
//            do {
//
//
//            } while (k > 0);
//
//        }
//    }
//    public String recur(int k) {
//        int n = k / 12;
//        int r = k % 12;
//        k = n;
//        if(k > 0) recur(k);
//        return null;
//    }

}
