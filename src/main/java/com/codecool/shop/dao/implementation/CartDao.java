package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface CartDao {
    void add(Product product);

    void remove(int id);

    Product getProductByid(int id);

    HashMap<Product, Integer> getAll();

    void clear();

    int getItemCount();

    BigDecimal getTotalPrice();
}
