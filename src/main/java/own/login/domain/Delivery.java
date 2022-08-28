package own.login.domain;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "DELIVERY_SEQ_GENERATOR", sequenceName = "DELIVERY_SEQ")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIVERY_SEQ_GENERATOR")
    private Long id;

    private String addrMain;
    private String addrSub;
}
