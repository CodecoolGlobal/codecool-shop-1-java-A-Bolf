package com.codecool.shop.model;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDao;
import com.codecool.shop.dao.implementation.CartDaoMem;

import java.util.HashMap;
import java.util.Map;

public class Order {

    public CartDao cart = CartDaoMem.getInstance();
    public HashMap<Product, Integer> order = cart.getAll();
    public Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }


}
