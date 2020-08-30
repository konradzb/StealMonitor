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
}
