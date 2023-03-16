package ru.netology.products;

public class Manager {
    Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.addProduct(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}
