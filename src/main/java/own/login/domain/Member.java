package own.login.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ"
)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String loginId;

    @Column(columnDefinition = "VARCHAR(50)")
    private String loginPasswd;

    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Grade grade;

    public Member(String loginId, String loginPasswd, Grade grade) {
        this.loginId = loginId;
        this.loginPasswd = loginPasswd;
        this.grade = grade;
    }

    public Member(String loginId, String loginPasswd) {
        this.loginId = loginId;
        this.loginPasswd = loginPasswd;
    }

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
