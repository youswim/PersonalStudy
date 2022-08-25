package own.login.domain;


import javax.persistence.*;
import java.sql.Clob;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(
        name="ITEM_SEQ_GENERATOR",
        sequenceName = "ITEM_SEQ"
)
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ_GENERATOR")
    private Long id;

    private String name;

    private Integer price;

    private Integer quantity;

    @Lob
    private String explanation;

    private LocalDateTime created;

    private LocalDateTime updated;
}
