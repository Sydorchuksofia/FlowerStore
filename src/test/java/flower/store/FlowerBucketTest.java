package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final double FLOWER_PRICE = 10;
    private double price = FLOWER_PRICE;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testInitialFlowerBucketIsEmpty() {
        Assertions.assertTrue(flowerBucket.getFlowerPacks().isEmpty());
    }

    @Test
    public void testEmptyFlowerBucketPrice() {
        Assertions.assertEquals(0, flowerBucket.getPrice());
    }

    @Test
    public void testPrice() {
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Rose();
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testMultiplePacksPrice() {
        int firstQuantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        int secondQuantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);

        Flower firstFlower = new Rose();
        firstFlower.setPrice(price);
        FlowerPack firstFlowerPack = new FlowerPack(firstFlower, firstQuantity);

        Flower secondFlower = new Tulip();
        secondFlower.setPrice(price);
        FlowerPack secondFlowerPack = new FlowerPack(secondFlower, secondQuantity);

        flowerBucket.add(firstFlowerPack);
        flowerBucket.add(secondFlowerPack);

        double expectedPrice = price * firstQuantity + price * secondQuantity;
        Assertions.assertEquals(expectedPrice, flowerBucket.getPrice());
    }
}
