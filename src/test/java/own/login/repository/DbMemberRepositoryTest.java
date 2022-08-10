package own.login.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import own.login.domain.Grade;
import own.login.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@ComponentScan
@DataJpaTest
@Transactional
class DbMemberRepositoryTest {

//    @PersistenceContext
//    private EntityManager em;

    @Autowired
    private MemberRepository memberRepository = new DbMemberRepository();

    @Test
    void clear() {
        memberRepository.clear();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setLoginId("hello");
        member.setLoginPasswd("passwd");
        member.setGrade(Grade.USER);

        Member savedMember = memberRepository.save(member);
        Assertions.assertThat(member).isEqualTo(savedMember);
    }

    @Test
    void findById() {
        Member member = new Member();
        member.setLoginId("hello");
        member.setLoginPasswd("passwd");
        member.setGrade(Grade.USER);
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId());

        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findByLoginId() {
        Member member = new Member();
        member.setLoginId("hello");
        member.setLoginPasswd("passwd");
        memberRepository.save(member);

        Member findMember = memberRepository.findByLoginId(member.getLoginId());
        Assertions.assertThat(findMember).isEqualTo(member);

    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setLoginId("hello");
        member1.setLoginPasswd("passwd");
        member1.setGrade(Grade.USER);

        Member member2 = new Member();
        member2.setLoginId("hello1");
        member2.setLoginPasswd("passwd2");
        member2.setGrade(Grade.USER);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> members = memberRepository.findAll();
        System.out.println(members);
        Assertions.assertThat(members.size()).isEqualTo(2);
        Assertions.assertThat(members).contains(member1, member2);
    }

}