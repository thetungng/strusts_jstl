package com.models;

import com.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    private List<Product> products;

    public ProductModel() {
        this.products = new ArrayList<Product>();
        this.products.add(new Product("p01", "name 1", "thumb1.gif", 2000));
        this.products.add(new Product("p02", "name 2", "thumb2.gif", 2100));
        this.products.add(new Product("p03", "name 3", "thumb3.gif", 2200));
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