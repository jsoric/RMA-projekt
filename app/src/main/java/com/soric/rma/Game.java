package com.soric.rma;

import java.io.Serializable;

public class Game implements Serializable {

    private int rank;
    private String title;
    private int sales;
    private String platform;
    private String release_date;
    private String developer;
    private String publisher;
    private String image_url;

    public Game(int rank, String title, int sales, String platform, String release_date, String developer, String publisher, String image_url) {
        this.rank = rank;
        this.title = title;
        this.sales = sales;
        this.platform = platform;
        this.release_date = release_date;
        this.developer = developer;
        this.publisher = publisher;
        this.image_url = image_url;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
