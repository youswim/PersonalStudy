package own.login.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import own.login.domain.Grade;
import own.login.domain.Member;
import own.login.repository.MemberRepository;
import own.login.repository.MemoryMemberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemberServiceImplTest {

    MemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach
    void before() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberServiceImpl(memberRepository);
    }

    @Test
    void save() {

        //given
        Member member1 = new Member();
        member1.setLoginId("hello");
        member1.setLoginPasswd("passwd");
        member1.setGrade(Grade.USER);

        Member member2 = new Member();
        member2.setLoginId("hello");
        member2.setLoginPasswd("passwd");
        member2.setGrade(Grade.USER);

        memberService.save(member1);
        //when
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.save(member2));
        //then
        assertThat(e.getMessage()).isEqualTo("LoginId 중복!");
    }

    @Test
    void findById() {
        // given
        Member member = new Member();
        member.setLoginId("hello");
        member.setLoginPasswd("passwd");
        member.setGrade(Grade.USER);

        // when
        Member savedMember = memberService.save(member);
        Member findMember = memberService.findById(savedMember.getId());

        // then
        assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member();
        member1.setLoginId("hello");
        member1.setLoginPasswd("passwd");
        member1.setGrade(Grade.USER);

        Member member2 = new Member();
        member2.setLoginId("hello1");
        member2.setLoginPasswd("passwd2");
        member2.setGrade(Grade.USER);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(member1, member2);
    }

    @Test
    void checkTrueMember() {

        Member member = new Member();
        member.setLoginId("hello");
        member.setLoginPasswd("passwd");
        memberService.save(member);

        Member trueMember = new Member();
        trueMember.setLoginId("hello");
        trueMember.setLoginPasswd("passwd");
        assertThat(memberService.checkMember(trueMember)).isEqualTo(true);
    }

    @Test
    void checkFalseLoginIdMember() {
        Member member = new Member();
        member.setLoginId("hello");
        member.setLoginPasswd("passwd");
        memberService.save(member);

        Member trueMember = new Member();
        trueMember.setLoginId("hello1");
        trueMember.setLoginPasswd("passwd");
        assertThat(memberService.checkMember(trueMember)).isEqualTo(false);
    }

    @Test
    void checkFalseLoginPasswdMember() {
        Member member = new Member();
        member.setLoginId("hello");
        member.setLoginPasswd("passwd");
        memberService.save(member);

        Member trueMember = new Member();
        trueMember.setLoginId("hello1");
        trueMember.setLoginPasswd("passwd1");
        assertThat(memberService.checkMember(trueMember)).isEqualTo(false);
    }



    @Test
    void findByLoginId() {
        Member member = new Member();
        member.setLoginId("hello");
        member.setLoginPasswd("passwd");
        memberService.save(member);

        Member findMember = memberService.findByLoginId(member.getLoginId());

        assertThat(findMember).isEqualTo(member);
    }
}