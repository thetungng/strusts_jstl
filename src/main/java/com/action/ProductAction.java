package com.action;

import java.util.List;

import com.entities.Product;
import com.models.ProductModel;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


@Namespace("/product")
public class ProductAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Action(value = "index", results = {
            @Result(name = SUCCESS, location = "/views/product/index.jsp")
    })
    public String index() {
        ProductModel productModel = new ProductModel();
        this.products = productModel.findAll();
        return SUCCESS;
    }

}