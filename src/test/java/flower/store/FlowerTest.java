package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }

    @Test
    public void testSepalLength() {
        double sepalLength = 3.5;
        flower.setSepalLength(sepalLength);
        Assertions.assertEquals(sepalLength, flower.getSepalLength());
    }

    @Test
    public void testFlowerType() {
        FlowerType type = FlowerType.CHAMOMILE;
        flower.setFlowerType(type);
        Assertions.assertEquals(FlowerType.CHAMOMILE, flower.getFlowerType());
    }

    @Test
    public void testAllArgsConstructor() {
        Flower flower = new Flower(5.5, FlowerColor.RED, 20.0, FlowerType.ROSE);
        Assertions.assertEquals(5.5, flower.getSepalLength());
        Assertions.assertEquals(FlowerColor.RED.getCode(), flower.getColor());
        Assertions.assertEquals(20.0, flower.getPrice());
        Assertions.assertEquals(FlowerType.ROSE, flower.getFlowerType());
    }
}
