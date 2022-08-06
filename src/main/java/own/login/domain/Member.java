package own.login.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ"
)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    private String loginId;

    private String loginPasswd;

    @Enumerated(value=EnumType.STRING)
    private Grade grade;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", loginPasswd='" + loginPasswd + '\'' +
                ", grade=" + grade +
                '}';
    }
}
