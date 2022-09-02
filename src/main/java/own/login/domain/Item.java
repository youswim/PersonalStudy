package own.login.domain;


import lombok.*;

import javax.persistence.*;
import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(
        name="ITEM_SEQ_GENERATOR",
        sequenceName = "ITEM_SEQ"
)
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ_GENERATOR")
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)")
    private String name;

    private Integer price;

    private Integer quantity;

    @Lob
    private String explain;

    public void setItem(Item item) {
        name = item.getName();
        price = item.getPrice();
        quantity = item.getQuantity();
        explain = item.getExplain();
    }



}
