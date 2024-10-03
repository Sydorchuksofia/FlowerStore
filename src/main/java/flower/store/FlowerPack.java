package flower.store;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class FlowerPack {
    private Flower flower;
    private int count;
    
    public FlowerPack(Flower flower, int amount) {
        this.flower = flower;
        this.count = amount;
    }

    public double getPrice() {
        return flower.getPrice() * count;
    }
}
