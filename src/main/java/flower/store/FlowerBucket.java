package flower.store;
import java.util.*;
public class FlowerBucket {
    private List<FlowerPack> flowerPacks;

    public FlowerBucket() {
        this.flowerPacks = new ArrayList<>();
    }

    public void addFlowerPack(FlowerPack flp) {
        flowerPacks.add(flp);
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack f : flowerPacks) {
            price += f.getPrice();
        }
        return price;
    }

        
}