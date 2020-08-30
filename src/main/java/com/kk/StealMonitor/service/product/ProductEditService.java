package com.kk.StealMonitor.service.product;

import com.google.common.base.Strings;
import com.kk.StealMonitor.dao.product.ProductDao;
import com.kk.StealMonitor.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductEditService {

    private ProductDao productDao;

    //Lists with ids, to update and delete
    private List<UUID> xKomIds;
    private Map<String,List<UUID>> idLists;

    @Autowired
    public ProductEditService(@Qualifier("PostgresProduct") ProductDao productDao) {
        this.productDao = productDao;
        this.idLists = new HashMap<>();
    }

    public int insertProduct(UUID id, Product newTask) {
        if(Strings.isNullOrEmpty(newTask.getName())
        || Strings.isNullOrEmpty(newTask.getSiteName())
        || Strings.isNullOrEmpty(newTask.getSiteLink())
        || Strings.isNullOrEmpty(newTask.getOldPrice())
        || Strings.isNullOrEmpty(newTask.getNewPrice())
        || Strings.isNullOrEmpty(newTask.getRemainingQuantity())
        || Strings.isNullOrEmpty(newTask.getLimitQuantity())
        || Strings.isNullOrEmpty(newTask.getImg())) {
            return 0;
        }
        return productDao.insertProduct(id, newTask);
    }

    public List<UUID> insertListOfProducts(List<Product> products) {
        List<UUID> idList = new ArrayList<>();
        products.forEach(product -> {
            UUID id = product.getId();
            idList.add(id);
            productDao.insertProduct(id, product);
        });
        return idList;
    }

    public int updateListOfProducts() {
        return 0;
    }

    public int deleteListOfProducts(List<UUID> idList) {
        idList.forEach(this::deleteTask);
        return 1;
    }

    //delete these 3 methods it u didn't use them
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public List<Product> getProductsWithCustomSql(String sql) {
        return productDao.getProductsWithCustomSql(sql);
    }

    public Optional<Product> selectTaskById(UUID id) {
        return productDao.selectProductById(id);
    }

    public int deleteTask(UUID id) {
        return productDao.deleteTask(id);
    }

    public List<UUID> getIdList(String key) {
        key = key.toLowerCase();
        return idLists.get(key);
    }

    public int setOrCreateIdList(String key, List<UUID> idList) {
        System.out.println(idList.size());
        key = key.toLowerCase();
        //check if it exist key like this,
        //in case no, create one and put into idLists
        if(idLists.containsKey(key))
            idLists.replace(key, idList);
        else
            idLists.put(key, idList);
        System.out.println(idList.size());
        return 1;
    }
}
