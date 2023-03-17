package ru.netology.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.products.*;

public class RepositoryTest {

    Product item1 = new Book(1, "Lolita", 100, "Nabokov");
    Product item2 = new Smartphone(2, "Samsung", 1000, "Japan");

    @Test
    public void addNotExistsProductTest() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);
        manager.add(item2);

        Product[] expected = {item1, item2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addExistsProductTest() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            manager.add(item1);;
        });
    }

    @Test
    public void deleteProductTest() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);
        manager.add(item2);

        Product[] expectedAdd = {item1, item2};
        Product[] actualAdd = repo.findAll();

        Assertions.assertArrayEquals(expectedAdd, actualAdd);

        repo.deleteProduct(1);

        Product[] expectedDelete = {item2};
        Product[] actualDelete = repo.findAll();

        Assertions.assertArrayEquals(expectedDelete, actualDelete);
    }

    @Test
    public void deleteExistedProductTest() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);
        manager.add(item2);

        repo.deleteProduct(1);

        Product[] expected = {item2};
        Product[] actual= repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteNotExistedProductTest() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);
        manager.add(item2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.deleteProduct(4);
        });
    }
}
