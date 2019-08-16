package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entities.Item;
import com.models.ProductModel;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/cart")
public class CartAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Action(value = "index", results = {
            @Result(name = SUCCESS, location = "/views/cart/index.jsp")
    })
    public String index() {
        return SUCCESS;
    }

    @Action(value = "buy", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = { "namespace", "/cart", "actionName", "index" })
    })
    public String buy() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        ProductModel productModel = new ProductModel();
        if (session.get("cart") == null) {
            List<Item> cart = new ArrayList<Item>();
            cart.add(new Item(productModel.find(id), 1));
            session.put("cart", cart);
        } else {
            List<Item> cart = (List<Item>) session.get("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Item(productModel.find(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.put("cart", cart);
        }
        return SUCCESS;
    }

    @Action(value = "remove", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = { "namespace", "/cart", "actionName", "index" })
    })
    public String remove() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        List<Item> cart = (List<Item>) session.get("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.put("cart", cart);
        return SUCCESS;
    }

    private int exists(String id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

}