package ru.netology.products;

import java.sql.RowIdLifetime;

public class Product {
    protected int ID;
    protected String name;
    protected int price;

    public Product(int ID, String name, int price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public boolean matches(String search) {
        return name.contains(search);
    }
}
