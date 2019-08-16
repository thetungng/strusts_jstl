package com.models;

import com.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    private List<Product> products;

    public ProductModel() {
        this.products = new ArrayList<Product>();
        this.products.add(new Product("product01", "name 1", "/assets/images/product.jpg", 2000));
        this.products.add(new Product("product02", "name 2", "/assets/images/product.jpg", 2100));
        this.products.add(new Product("product03", "name 3", "/assets/images/product.jpg", 2200));
    }

    public List<Product> findAll() {
        return this.products;
    }

    public Product find(String id) {
        for (Product product : this.products) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }

}