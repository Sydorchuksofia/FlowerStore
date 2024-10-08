package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerPackTest {

    private FlowerPack flowerPack;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower(5.5, FlowerColor.RED, 20.0, FlowerType.ROSE);
        flowerPack = new FlowerPack(flower, 10);
    }

    @Test
    public void testAllArgsConstructor() {
        Assertions.assertEquals(flower, flowerPack.getFlower());
        Assertions.assertEquals(10, flowerPack.getCount());
    }

    @Test
    public void testGetPrice() {
        double expectedPrice = flower.getPrice() * 10;
        Assertions.assertEquals(expectedPrice, flowerPack.getPrice());
    }

    @Test
    public void testGetFlower() {
        Assertions.assertEquals(flower, flowerPack.getFlower());
    }

    @Test
    public void testSetFlower() {
        Flower newFlower = new Flower(6.0, FlowerColor.WHITE, 15.0, FlowerType.TULIP);
        flowerPack.setFlower(newFlower);
        Assertions.assertEquals(newFlower, flowerPack.getFlower());
    }

    @Test
    public void testGetCount() {
        Assertions.assertEquals(10, flowerPack.getCount());
    }

    @Test
    public void testSetCount() {
        flowerPack.setCount(5);
        Assertions.assertEquals(5, flowerPack.getCount());
    }
}