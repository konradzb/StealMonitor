package com.kk.StealMonitor.model;

import java.util.UUID;

public class Product {

    private UUID id;
    private int id_auto;
    private String name;
    private String siteName;
    private String siteLink;
    private String oldPrice, newPrice;
    private String remainingQuantity, limitQuantity;
    private String img;
    private String category;

    public Product(UUID id, int id_auto, String name, String siteName, String siteLink, String oldPrice, String newPrice, String remainingQuantity, String limitQuantity, String img, String category) {
        this.id = id;
        this.id_auto = id_auto;
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

    public Product(UUID id, String name, String siteName, String siteLink, String oldPrice, String newPrice, String remainingQuantity, String limitQuantity, String img, String category) {
        this(id, -1, name, siteName, siteLink, oldPrice, newPrice, remainingQuantity, limitQuantity, img, category);
    }

    public UUID getId() {
        return id;
    }

    public int getId_auto() {
        return id_auto;
    }

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
