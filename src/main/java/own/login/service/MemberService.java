package own.login.service;

import own.login.domain.Member;

import java.util.List;

public interface MemberService {

    public Member save(Member member);

    public Member findById(Long id);

    public List<Member> findAll();

    public boolean checkMember(Member member);

    public Member findByLoginId(String loginId);

    public void clear();
}
