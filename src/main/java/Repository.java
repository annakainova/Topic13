public class Repository {

    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void addProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];

        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }

        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void deleteProduct(int ID) {
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
}
