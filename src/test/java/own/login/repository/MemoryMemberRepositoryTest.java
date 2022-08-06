package own.login.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import own.login.domain.Grade;
import own.login.domain.Member;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void after() {
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
        Assertions.assertThat(members.size()).isEqualTo(2);
        Assertions.assertThat(members).contains(member1, member2);
    }
}