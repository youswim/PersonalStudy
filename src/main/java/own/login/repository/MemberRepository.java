package own.login.repository;

import own.login.domain.Member;

import java.util.List;

public interface MemberRepository {

    public Member save(Member member);

    public Member findById(Long id);

    public List<Member> findAll();

    public Member findByLoginId(String loginId);

    public void deleteAll();


}
