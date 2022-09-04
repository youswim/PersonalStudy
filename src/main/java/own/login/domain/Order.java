package own.login.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
@SequenceGenerator(
        name = "ORDER_SEQ_GENERATOR",
        sequenceName = "ORDER_SEQ"
)
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(5)")
    private Status status;

    private LocalDateTime createdAt;


}
