package com.kk.StealMonitor.model;

import java.util.UUID;

public class Page {
    private UUID id;
    private int id_auto;
    private String url;
    private String divClassName;
    private String scraperClassPath;
    private String updateTime;
    private String getTime;

    public Page(UUID id, int id_auto, String url, String divClassName, String scraperClassPath, String updateTime, String hoursBetween) {
        this.id = id;
        this.id_auto = id_auto;
        this.url = url;
        this.divClassName = divClassName;
        this.scraperClassPath = scraperClassPath;
        this.updateTime = updateTime;
        this.getTime = hoursBetween;
    }

    public Page(UUID id, String url, String divClassName, String scraperClassPath, String updateTime, String hoursBetween) {
        this(id, -1, url, divClassName, scraperClassPath, updateTime, hoursBetween);
    }

    public UUID getId() {
        return id;
    }

    public int getId_auto() {
        return id_auto;
    }

    public String getUrl() {
        return url;
    }

    public String getDivClassName() {
        return divClassName;
    }

    public String getScraperClassPath() {
        return scraperClassPath;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getGetTime() {
        return getTime;
    }
}
