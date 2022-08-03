package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data //@Data는 위험할 수 있으니 주의해서 사용필요
//@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;


    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
