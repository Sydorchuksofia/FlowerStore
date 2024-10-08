package flower.store;

public class Rose extends Flower {
    
    public Rose(double sepalLength, FlowerColor color, double price) {
        super(sepalLength, color, price, FlowerType.ROSE);
    }

    public Rose() {
    }
}