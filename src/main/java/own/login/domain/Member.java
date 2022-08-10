package own.login.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(loginId, member.loginId) && Objects.equals(loginPasswd, member.loginPasswd) && grade == member.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loginId, loginPasswd, grade);
    }
}
