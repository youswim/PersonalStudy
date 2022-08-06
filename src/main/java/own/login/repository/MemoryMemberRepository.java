package own.login.repository;

import org.springframework.stereotype.Repository;
import own.login.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    Map<Long, Member> map = new HashMap<>();
    Long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        map.put(member.getId(), member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        return map.get(id);
    }

    public Member findByLoginId(String loginId) {
        for (Long key : map.keySet()) {
            Member iterMember = map.get(key);
            if (iterMember.getLoginId().equals(loginId))
                return iterMember;
        }
        return null;
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(map.values());

    }

    @Override
    public void clear() {
        map.clear();
    }
}
