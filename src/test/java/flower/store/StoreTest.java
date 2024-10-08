package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StoreTest {
    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    public void testAddBucket() {
        Flower flower = new Rose(5.0, FlowerColor.RED, 10.0);
        FlowerPack flowerPack = new FlowerPack(flower, 5);
        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(flowerPack);
        
        store.addBucket(flowerBucket);
        
        Assertions.assertEquals(1, store.search(FlowerType.ROSE).size());
    }

    @Test
    public void testSearchFlowerType() {
        Flower rose = new Rose(5.0, FlowerColor.RED, 10.0);
        Flower tulip = new Tulip(6.0, FlowerColor.YELLOW, 15.0);
        
        FlowerPack rosePack = new FlowerPack(rose, 3);
        FlowerPack tulipPack = new FlowerPack(tulip, 2);
        
        FlowerBucket bucket1 = new FlowerBucket();
        bucket1.add(rosePack);
        
        FlowerBucket bucket2 = new FlowerBucket();
        bucket2.add(tulipPack);
        
        store.addBucket(bucket1);
        store.addBucket(bucket2);
        
        List<FlowerBucket> foundBuckets = store.search(FlowerType.ROSE);
        
        Assertions.assertEquals(1, foundBuckets.size());
        Assertions.assertEquals(FlowerType.ROSE, foundBuckets.get(0).getFlowerPacks().get(0).getFlower().getFlowerType());
    }

    @Test
    public void testSearchFlowerTypeNotFound() {
        Flower flower = new Rose(5.0, FlowerColor.RED, 10.0);
        FlowerPack flowerPack = new FlowerPack(flower, 5);
        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(flowerPack);
        
        store.addBucket(flowerBucket);
        
        List<FlowerBucket> foundBuckets = store.search(FlowerType.TULIP); // Search for a different type
        
        Assertions.assertEquals(0, foundBuckets.size());
    }
}