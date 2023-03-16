package ru.netology.products;

public class Book extends Product {
    private String author;

    public Book(int ID, String name, int price, String author) {
        super(ID, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (author.contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
