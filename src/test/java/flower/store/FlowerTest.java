package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {

    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private static final double INITIAL_SEPAL_LENGTH = 5.5;
    private static final FlowerColor INITIAL_COLOR = FlowerColor.RED;
    private static final double INITIAL_PRICE = 20.0;
    private static final FlowerType INITIAL_FLOWER_TYPE = FlowerType.ROSE;
    private static final double TEST_SEPAL_LENGTH = 3.5;
    private static final FlowerType TEST_FLOWER_TYPE = FlowerType.CHAMOMILE;

    private Flower flower;

    @BeforeEach
    public void init() {
        this.flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testColor() {
        FlowerColor color = INITIAL_COLOR;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }

    @Test
    public void testSepalLength() {
        double sepalLength = TEST_SEPAL_LENGTH;
        flower.setSepalLength(sepalLength);
        Assertions.assertEquals(sepalLength, flower.getSepalLength());
    }

    @Test
    public void testFlowerType() {
        FlowerType type = TEST_FLOWER_TYPE;
        flower.setFlowerType(type);
        Assertions.assertEquals(TEST_FLOWER_TYPE, flower.getFlowerType());
    }

    @Test
    public void testAllArgsConstructor() {
        Flower flower = new Flower(INITIAL_SEPAL_LENGTH, INITIAL_COLOR, INITIAL_PRICE, INITIAL_FLOWER_TYPE);
        Assertions.assertEquals(INITIAL_SEPAL_LENGTH, flower.getSepalLength());
        Assertions.assertEquals(INITIAL_COLOR.getCode(), flower.getColor());
        Assertions.assertEquals(INITIAL_PRICE, flower.getPrice());
        Assertions.assertEquals(INITIAL_FLOWER_TYPE, flower.getFlowerType());
    }
}
