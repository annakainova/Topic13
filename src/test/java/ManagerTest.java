import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Product item1 = new Book(1, "Lolita", 100, "Nabokov");
    Product item2 = new Smartphone(2, "Samsung", 1000, "Japan");

    @Test
    public void addProductTest() {

        Repository repo = new Repository();
        Manager  manager= new Manager(repo);

        manager.add(item1);

        Product[] expected = {item1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfFoundTest () {
        Repository repo = new Repository();
        Manager  manager= new Manager(repo);

        manager.add(item1);
        manager.add(item2);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Lolita");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfNotFoundTest () {
        Repository repo = new Repository();
        Manager  manager= new Manager(repo);

        manager.add(item1);
        manager.add(item2);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Book1");

        Assertions.assertArrayEquals(expected, actual);
    }
}
