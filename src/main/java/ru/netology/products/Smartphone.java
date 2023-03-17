package ru.netology.products;

import ru.netology.products.Product;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int ID, String name, int price, String manufacturer) {
        super(ID, name, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (manufacturer.contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
