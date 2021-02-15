package com.kk.StealMonitor.model;

import java.util.UUID;

public class Product {

    private UUID id;
<<<<<<< HEAD
    private String siteLink;
    private String siteName;
    private String name;
=======
    private int id_auto;
    private String name;
    private String siteName;
    private String siteLink;
>>>>>>> ba2bd4e93cd2bdc63adebd3e8be115630d8388e2
    private String oldPrice, newPrice;
    private String remainingQuantity, limitQuantity;
    private String img;
    private String category;

<<<<<<< HEAD
    public Product(UUID id, String siteLink, String siteName, String name, String oldPrice, String newPrice, String remainingQuantity, String limitQuantity, String img, String category) {
        this.id = id;
=======
    public Product(UUID id, int id_auto, String name, String siteName, String siteLink, String oldPrice, String newPrice, String remainingQuantity, String limitQuantity, String img, String category) {
        this.id = id;
        this.id_auto = id_auto;
>>>>>>> ba2bd4e93cd2bdc63adebd3e8be115630d8388e2
        this.siteLink = siteLink;
        this.siteName = siteName;
        this.name = name;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.remainingQuantity = remainingQuantity;
        this.limitQuantity = limitQuantity;
        this.img = img;
        this.category = category;
    }

<<<<<<< HEAD
=======
    public Product(UUID id, String name, String siteName, String siteLink, String oldPrice, String newPrice, String remainingQuantity, String limitQuantity, String img, String category) {
        this(id, -1, name, siteName, siteLink, oldPrice, newPrice, remainingQuantity, limitQuantity, img, category);
    }

>>>>>>> ba2bd4e93cd2bdc63adebd3e8be115630d8388e2
    public UUID getId() {
        return id;
    }

<<<<<<< HEAD
=======
    public int getId_auto() {
        return id_auto;
    }

>>>>>>> ba2bd4e93cd2bdc63adebd3e8be115630d8388e2
    public String getSiteLink() {
        return siteLink;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getName() {
        return name;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public String getRemainingQuantity() {
        return remainingQuantity;
    }

    public String getLimitQuantity() {
        return limitQuantity;
    }

    public String getImg() {
        return img;
    }

    public String getCategory() {
        return category;
    }
}
<<<<<<< HEAD

=======
>>>>>>> ba2bd4e93cd2bdc63adebd3e8be115630d8388e2
