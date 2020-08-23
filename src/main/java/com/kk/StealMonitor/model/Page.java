package com.kk.StealMonitor.model;

import java.util.UUID;

public class Page {
    private UUID id;
    private int id_auto;
    private String url = null;
    private String divClassName;
    private String scraperClassPath;
    private String refreshTime;
    private String hoursBetween;

    public Page(UUID id, String url, String divClassName, String scraperClassPath, String refreshTime, String hoursBetween) {
        this.id = id;
        this.url = url;
        this.divClassName = divClassName;
        this.scraperClassPath = scraperClassPath;
        this.refreshTime = refreshTime;
        this.hoursBetween = hoursBetween;
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

    public String getRefreshTime() {
        return refreshTime;
    }

    public String getHoursBetween() {
        return hoursBetween;
    }

}
