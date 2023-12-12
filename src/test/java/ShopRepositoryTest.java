import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product = new Product(5, "Позвонить родителям", 555);

    @Test
    public void romoveTest() {
        ShopRepository addedproduct = new ShopRepository();
        ShopRepository expected = addedproduct;
        addedproduct.aDD(product);


        addedproduct.remove(5);
        ShopRepository actual = addedproduct;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void exeptiomTest() {
        ShopRepository addedproduct = new ShopRepository();


        Assertions.assertThrows(NotFoundException.class, () -> {
            addedproduct.remove(5);
        });
    }
}
