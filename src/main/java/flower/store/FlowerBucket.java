package flower.store;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class FlowerBucket {
    
    private List<FlowerPack> flowerPacks;

    public FlowerBucket() {
        this.flowerPacks = new ArrayList<>();
    }

    public void add(FlowerPack flp) {
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