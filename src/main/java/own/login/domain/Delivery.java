package own.login.domain;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "DELIVERY_SEQ_GENERATOR", sequenceName = "DELIVERY_SEQ")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIVERY_SEQ_GENERATOR")
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String addrMain;

    @Column(columnDefinition = "VARCHAR(50)")
    private String addrSub;

    @Column(columnDefinition = "VARCHAR(50)")
    private String deliveryReq; // 배달 시 요청사항
}
