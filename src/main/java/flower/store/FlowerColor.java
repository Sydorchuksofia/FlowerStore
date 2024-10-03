package flower.store;
import lombok.*;

@Getter

public enum FlowerColor {
    RED("#FF0000"), BLUE(""), YELLOW(""), WHITE("");

    private String code;

    FlowerColor(String code) {
        this.code = code;
    }

}
