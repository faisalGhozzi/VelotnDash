package com.velotn.entity;

public class Wishlist {
    private int id;
    private int product_id;
    private int user_id;
    private double prix;
    private String nomProd;
    private String url;
    public Wishlist() {
    }

    public Wishlist(int id) {
        this.id = id;
    }

    public Wishlist(int id, String nomProd, double prix, String url){
        this.id = id;
        this.nomProd = nomProd;
        this.prix = prix;
        this.url = url;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Wishlist(int id, int product_id, int user_id) {
        this.id = id;
        this.product_id = product_id;
        this.user_id = user_id;
    }

    public Wishlist(int product_id, int user_id) {
        this.product_id = product_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
