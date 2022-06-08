package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        CartDaoMem cartDataStore = CartDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);

        //setting up products and printing it
        Product iphone = new Product("Iphone", new BigDecimal("500"), "USD", "A phone from Apple", tablet, amazon);
        productDataStore.add(iphone);
        cartDataStore.add(iphone);
        Product samsung = new Product("Samsung", new BigDecimal("200"), "USD", "A phone from Samsung", tablet, lenovo);
        productDataStore.add(samsung);
        cartDataStore.add(samsung);
        Product oneplus = new Product("Oneplus", new BigDecimal("300"), "USD", "A phone from OnePlus", tablet, amazon);
        productDataStore.add(oneplus);
        cartDataStore.add(oneplus);
        Product fairyDust = new Product("\"Fairy Dust\"", new BigDecimal("500"), "USD", "Magic white powder", tablet, amazon);
        productDataStore.add(fairyDust);
        cartDataStore.add(fairyDust);
    }
}
