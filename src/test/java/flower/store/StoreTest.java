package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StoreTest {

    // Constants for magic numbers
    private static final double ROSE_SEPAL_LENGTH = 5.0;
    private static final double ROSE_PRICE = 10.0;
    private static final int ROSE_COUNT = 5;

    private static final double TULIP_SEPAL_LENGTH = 6.0;
    private static final double TULIP_PRICE = 15.0;
    private static final int TULIP_COUNT = 2;

    private static final int EXPECTED_ROSE_SEARCH_SIZE = 1;
    private static final int EXPECTED_NO_FLOWER_FOUND_SIZE = 0;

    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    public void testAddBucket() {
        Flower flower = new Rose(ROSE_SEPAL_LENGTH, FlowerColor.RED, ROSE_PRICE);
        FlowerPack flowerPack = new FlowerPack(flower, ROSE_COUNT);
        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(flowerPack);

        store.addBucket(flowerBucket);

        Assertions.assertEquals(EXPECTED_ROSE_SEARCH_SIZE, store.search(FlowerType.ROSE).size());
    }

    @Test
    public void testSearchFlowerType() {
        Flower rose = new Rose(ROSE_SEPAL_LENGTH, FlowerColor.RED, ROSE_PRICE);
        Flower tulip = new Tulip(TULIP_SEPAL_LENGTH, FlowerColor.YELLOW, TULIP_PRICE);

        FlowerPack rosePack = new FlowerPack(rose, ROSE_COUNT);
        FlowerPack tulipPack = new FlowerPack(tulip, TULIP_COUNT);

        FlowerBucket bucket1 = new FlowerBucket();
        bucket1.add(rosePack);

        FlowerBucket bucket2 = new FlowerBucket();
        bucket2.add(tulipPack);

        store.addBucket(bucket1);
        store.addBucket(bucket2);

        List<FlowerBucket> foundBuckets = store.search(FlowerType.ROSE);

        Assertions.assertEquals(EXPECTED_ROSE_SEARCH_SIZE, foundBuckets.size());
        Assertions.assertEquals(FlowerType.ROSE,
                foundBuckets.get(0).getFlowerPacks().get(0).getFlower().getFlowerType());
    }

    @Test
    public void testSearchFlowerTypeNotFound() {
        Flower flower = new Rose(ROSE_SEPAL_LENGTH, FlowerColor.RED, ROSE_PRICE);
        FlowerPack flowerPack = new FlowerPack(flower, ROSE_COUNT);
        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(flowerPack);

        store.addBucket(flowerBucket);

        List<FlowerBucket> foundBuckets = store.search(FlowerType.TULIP); // Search for a different type

        Assertions.assertEquals(EXPECTED_NO_FLOWER_FOUND_SIZE, foundBuckets.size());
    }
}
