package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StoreTest {

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

        private FlowerBucket createFlowerBucket(FlowerType flowerType,
                        double sepalLength,
                        FlowerColor color,
                        double price,
                        int count) {
                Flower flower;
                switch (flowerType) {
                        case ROSE:
                                flower = new Rose(sepalLength, color, price);
                                break;
                        case TULIP:
                                flower = new Tulip(sepalLength, color, price);
                                break;
                        default:
                                throw new IllegalArgumentException("Unknown");
                }
                FlowerPack flowerPack = new FlowerPack(flower, count);
                FlowerBucket flowerBucket = new FlowerBucket();
                flowerBucket.add(flowerPack);
                return flowerBucket;
        }

        @Test
        public void testAddBucket() {
                FlowerBucket flowerBucket = createFlowerBucket(FlowerType.ROSE,
                                ROSE_SEPAL_LENGTH,
                                FlowerColor.RED,
                                ROSE_PRICE,
                                ROSE_COUNT);
                store.addBucket(flowerBucket);

                Assertions.assertEquals(EXPECTED_ROSE_SEARCH_SIZE,
                                store.search(FlowerType.ROSE).size());
        }

        @Test
        public void testSearchFlowerType() {
                FlowerBucket bucketOne = createFlowerBucket(FlowerType.ROSE,
                                ROSE_SEPAL_LENGTH,
                                FlowerColor.RED,
                                ROSE_PRICE,
                                ROSE_COUNT);
                FlowerBucket bucketTwo = createFlowerBucket(FlowerType.TULIP,
                                TULIP_SEPAL_LENGTH,
                                FlowerColor.YELLOW,
                                TULIP_PRICE,
                                TULIP_COUNT);

                store.addBucket(bucketOne);
                store.addBucket(bucketTwo);

                List<FlowerBucket> foundBuckets = store.search(FlowerType.ROSE);

                Assertions.assertEquals(EXPECTED_ROSE_SEARCH_SIZE,
                                foundBuckets.size());
        }

        @Test
        public void testSearchFlowerTypeNotFound() {
                FlowerBucket flowerBucket = createFlowerBucket(FlowerType.ROSE,
                                ROSE_SEPAL_LENGTH,
                                FlowerColor.RED,
                                ROSE_PRICE,
                                ROSE_COUNT);
                store.addBucket(flowerBucket);

                List<FlowerBucket> foundBuckets = 
                store.search(FlowerType.TULIP);

                Assertions.assertEquals(EXPECTED_NO_FLOWER_FOUND_SIZE,
                                foundBuckets.size());
        }
}
