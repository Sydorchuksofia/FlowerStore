package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;

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
        flower.setPrice(10);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(10 * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testMultiplePacksPrice() {
        int quantity1 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        int quantity2 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);

        Flower flower1 = new Rose();
        flower1.setPrice(10);
        FlowerPack flowerPack1 = new FlowerPack(flower1, quantity1);

        Flower flower2 = new Tulip();
        flower2.setPrice(5);
        FlowerPack flowerPack2 = new FlowerPack(flower2, quantity2);

        flowerBucket.add(flowerPack1);
        flowerBucket.add(flowerPack2);

        double expectedPrice = 10 * quantity1 + 5 * quantity2;
        Assertions.assertEquals(expectedPrice, flowerBucket.getPrice());
    }
}
