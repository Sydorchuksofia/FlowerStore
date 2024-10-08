package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class FlowerTypeTest {
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
        rose = new Rose(4.5, FlowerColor.RED, 30.0);
        Assertions.assertEquals(4.5, rose.getSepalLength());
        Assertions.assertEquals(FlowerColor.RED.getCode(), rose.getColor());
        Assertions.assertEquals(30.0, rose.getPrice());
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
        tulip = new Tulip(3.0, FlowerColor.YELLOW, 15.0);
        Assertions.assertEquals(3.0, tulip.getSepalLength());
        Assertions.assertEquals(FlowerColor.YELLOW.getCode(), tulip.getColor());
        Assertions.assertEquals(15.0, tulip.getPrice());
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
        chamomile = new Chamomile(2.5, FlowerColor.WHITE, 10.0);
        Assertions.assertEquals(2.5, chamomile.getSepalLength());
        Assertions.assertEquals(FlowerColor.WHITE.getCode(), chamomile.getColor());
        Assertions.assertEquals(10.0, chamomile.getPrice());
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