package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerTypeTest {

    // Constants for magic numbers
    private static final double ROSE_SEPAL_LENGTH = 4.5;
    private static final double ROSE_PRICE = 30.0;
    private static final FlowerColor ROSE_COLOR = FlowerColor.RED;

    private static final double TULIP_SEPAL_LENGTH = 3.0;
    private static final double TULIP_PRICE = 15.0;
    private static final FlowerColor TULIP_COLOR = FlowerColor.YELLOW;

    private static final double CHAMOMILE_SEPAL_LENGTH = 2.5;
    private static final double CHAMOMILE_PRICE = 10.0;
    private static final FlowerColor CHAMOMILE_COLOR = FlowerColor.WHITE;

    private Rose rose;
    private Tulip tulip;
    private Chamomile chamomile;

    @BeforeEach
    public void init() {
        rose = new Rose();
        tulip = new Tulip();
        chamomile = new Chamomile();
    }

    @Test
    public void testRoseAllArgsConstructor() {
        rose = new Rose(ROSE_SEPAL_LENGTH, ROSE_COLOR, ROSE_PRICE);
        Assertions.assertEquals(ROSE_SEPAL_LENGTH, rose.getSepalLength());
        Assertions.assertEquals(ROSE_COLOR.getCode(), rose.getColor());
        Assertions.assertEquals(ROSE_PRICE, rose.getPrice());
        Assertions.assertEquals(FlowerType.ROSE, rose.getFlowerType());
    }

    @Test
    public void testRoseDefaultConstructor() {
        Assertions.assertNull(rose.getFlowerType());
        Assertions.assertNull(rose.getColor());
        Assertions.assertEquals(0, rose.getSepalLength());
        Assertions.assertEquals(0, rose.getPrice());
    }

    @Test
    public void testTulipAllArgsConstructor() {
        tulip = new Tulip(TULIP_SEPAL_LENGTH, TULIP_COLOR, TULIP_PRICE);
        Assertions.assertEquals(TULIP_SEPAL_LENGTH, tulip.getSepalLength());
        Assertions.assertEquals(TULIP_COLOR.getCode(), tulip.getColor());
        Assertions.assertEquals(TULIP_PRICE, tulip.getPrice());
        Assertions.assertEquals(FlowerType.TULIP, tulip.getFlowerType());
    }

    @Test
    public void testTulipDefaultConstructor() {
        Assertions.assertNull(tulip.getFlowerType());
        Assertions.assertNull(tulip.getColor());
        Assertions.assertEquals(0, tulip.getSepalLength());
        Assertions.assertEquals(0, tulip.getPrice());
    }

    @Test
    public void testChamomileAllArgsConstructor() {
        chamomile = new Chamomile(CHAMOMILE_SEPAL_LENGTH, CHAMOMILE_COLOR, CHAMOMILE_PRICE);
        Assertions.assertEquals(CHAMOMILE_SEPAL_LENGTH, chamomile.getSepalLength());
        Assertions.assertEquals(CHAMOMILE_COLOR.getCode(), chamomile.getColor());
        Assertions.assertEquals(CHAMOMILE_PRICE, chamomile.getPrice());
        Assertions.assertEquals(FlowerType.CHAMOMILE, chamomile.getFlowerType());
    }

    @Test
    public void testChamomileDefaultConstructor() {
        Assertions.assertNull(chamomile.getFlowerType());
        Assertions.assertNull(chamomile.getColor());
        Assertions.assertEquals(0, chamomile.getSepalLength());
        Assertions.assertEquals(0, chamomile.getPrice());
    }

    @Test
    public void testFlowerTypeEnumValues() {
        FlowerType[] expectedTypes = { FlowerType.CHAMOMILE, FlowerType.ROSE, FlowerType.TULIP };
        Assertions.assertArrayEquals(expectedTypes, FlowerType.values());
    }

    @Test
    public void testFlowerTypeEnumValueOf() {
        Assertions.assertEquals(FlowerType.ROSE, FlowerType.valueOf("ROSE"));
        Assertions.assertEquals(FlowerType.CHAMOMILE, FlowerType.valueOf("CHAMOMILE"));
        Assertions.assertEquals(FlowerType.TULIP, FlowerType.valueOf("TULIP"));
    }
}
