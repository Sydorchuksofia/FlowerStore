package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flower {

    private double sepalLength;
    private FlowerColor color;
    private double price;
    private FlowerType flowerType;

    public Flower(Flower fl) {
        this.color = fl.color;
        this.price = fl.price;
        this.sepalLength = fl.sepalLength;
        this.flowerType = fl.flowerType;
    }

    public String getColor() {
        if (color != null) {
            return color.getCode();
        } else {
            return null;
        }
    }
    
}
