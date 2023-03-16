package ru.netology.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.products.*;

public class ManagerTest {

    Product item1 = new Book(1, "Lolita", 100, "Nabokov");
    Product item2 = new Smartphone(2, "Samsung", 1000, "South Korea");
    Product item3 = new Smartphone(3, "Samsung", 1100, "South Korea");
    Product item4 = new Book(4, "Pinokkio", 1100, "Kollodi");

    @Test
    public void addProductTest() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);

        Product[] expected = {item1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfFoundTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);
        manager.add(item2);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Lolita");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfNotFoundTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);
        manager.add(item2);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Book1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfFoundMoreThanOneTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {item2, item3};
        Product[] actual = manager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Nabokov");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByManufacturerTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {item2, item3};
        Product[] actual = manager.searchBy("South Korea");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorOneBookTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(item1);
        manager.add(item4);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Nabokov");

        Assertions.assertArrayEquals(expected, actual);
    }
}
