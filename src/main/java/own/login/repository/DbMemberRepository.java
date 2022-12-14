package own.login.repository;

import org.springframework.stereotype.Repository;
import own.login.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
//@RequiredArgsConstructor
public class DbMemberRepository implements MemberRepository {

    @PersistenceContext
    private EntityManager em;

//    private final EntityManager em;

    @Override
    @Transactional
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    @Override
    public Member findByLoginId(String loginId) {
        String query = "select m from Member m where m.loginId=:loginId";
        List<Member> members = em.createQuery(query, Member.class)
                .setParameter("loginId", loginId)
                .getResultList();
        for (Member member : members) {
            if (member.getLoginId().equals(loginId)) {
                return member;
            }
        }
        return null;
    }


    @Override
    @Transactional
    public void deleteAll() {
        em.createQuery("delete from Member m").executeUpdate();
    }
}
