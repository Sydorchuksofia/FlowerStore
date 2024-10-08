package flower.store;
import lombok.*;

@Getter

public enum FlowerColor {
    RED("#FF0000"), BLUE("#FF0000"), YELLOW("#FF0000"), WHITE("#FF0000");

    private String code;

    FlowerColor(String code) {
        this.code = code;
    }

}
