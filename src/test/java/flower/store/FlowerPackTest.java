package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerPackTest {

    // Static constants placed before instance variables
    private static final double INITIAL_SEPAL_LENGTH = 5.5;
    private static final FlowerColor INITIAL_COLOR = FlowerColor.RED;
    private static final double INITIAL_PRICE = 20.0;
    private static final FlowerType INITIAL_FLOWER_TYPE = FlowerType.ROSE;
    private static final int INITIAL_COUNT = 10;

    private static final double NEW_SEPAL_LENGTH = 6.0;
    private static final FlowerColor NEW_COLOR = FlowerColor.WHITE;
    private static final double NEW_PRICE = 15.0;
    private static final FlowerType NEW_FLOWER_TYPE = FlowerType.TULIP;
    private static final int NEW_COUNT = 5;

    private FlowerPack flowerPack;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower(INITIAL_SEPAL_LENGTH, INITIAL_COLOR, INITIAL_PRICE, INITIAL_FLOWER_TYPE);
        flowerPack = new FlowerPack(flower, INITIAL_COUNT);
    }

    @Test
    public void testAllArgsConstructor() {
        Assertions.assertEquals(flower, flowerPack.getFlower());
        Assertions.assertEquals(INITIAL_COUNT, flowerPack.getCount());
    }

    @Test
    public void testGetPrice() {
        double expectedPrice = flower.getPrice() * INITIAL_COUNT;
        Assertions.assertEquals(expectedPrice, flowerPack.getPrice());
    }

    @Test
    public void testGetFlower() {
        Assertions.assertEquals(flower, flowerPack.getFlower());
    }

    @Test
    public void testSetFlower() {
        Flower newFlower = new Flower(NEW_SEPAL_LENGTH, NEW_COLOR, NEW_PRICE, NEW_FLOWER_TYPE);
        flowerPack.setFlower(newFlower);
        Assertions.assertEquals(newFlower, flowerPack.getFlower());
    }

    @Test
    public void testGetCount() {
        Assertions.assertEquals(INITIAL_COUNT, flowerPack.getCount());
    }

    @Test
    public void testSetCount() {
        flowerPack.setCount(NEW_COUNT);
        Assertions.assertEquals(NEW_COUNT, flowerPack.getCount());
    }
}
