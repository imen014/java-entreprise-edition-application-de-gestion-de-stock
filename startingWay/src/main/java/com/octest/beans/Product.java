package com.octest.beans;

public class Product {

    private int id;
    private String nom_produit;
    private int quantite_stock;
    private float prix;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNom_produit() {
	return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
	this.nom_produit = nom_produit;
    }

    public int getQuantite_stock() {
	return quantite_stock;
    }

    public void setQuantite_stock(int quantite_stock) {
	this.quantite_stock = quantite_stock;
    }

    public float getPrix() {
	return prix;
    }

    public void setPrix(float prix) {
	this.prix = prix;
    }

    public Product() {
	super();
    }

    public Product(String nom_produit, int quantite_stock, float prix, String code_produit,
	    CategorieProduct categorie_product) {
	super();
	this.nom_produit = nom_produit;
	this.quantite_stock = quantite_stock;
	this.prix = prix;
	this.code_produit = code_produit;
	this.categorie_product = categorie_product;
    }

}
