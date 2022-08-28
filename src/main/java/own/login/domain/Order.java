package own.login.domain;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
@SequenceGenerator(
        name = "ORDER_SEQ_GENERATOR",
        sequenceName = "ORDER_SEQ"
)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    
    @Enumerated(value = EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;


}
