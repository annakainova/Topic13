package ru.netology.products;

import ru.netology.products.Product;

public class Repository {

    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void addProduct(Product product) {

        if (findById(product.ID) != null) {
            throw new AlreadyExistsException("Element with id: " + product.ID + " already exists");
        }

        Product[] tmp = new Product[products.length + 1];

        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }

        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void deleteProduct(int ID) {
        if (findById(ID) == null) {
            throw new NotFoundException("Element with id: " + ID + " not found");
        }

        Product[] tmp = new Product[products.length - 1];

        int i = 0;
        for (Product product : products) {
            if (product.ID != ID) {
                tmp[i] = product;
                i++;
            }
        }
        products = tmp;
    }

    public Product findById(int ID) {
        for (Product product : products) {
            if (product.ID == ID) {
                return product;
            }
        }
        return null;
    }

}
