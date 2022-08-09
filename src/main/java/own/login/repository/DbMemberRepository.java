package own.login.repository;

import org.springframework.stereotype.Repository;
import own.login.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DbMemberRepository implements MemberRepository {

    @PersistenceContext
    EntityManager em;

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
        return em.createQuery(query, Member.class)
                .setParameter("loginId", loginId)
                .getResultList()
                .get(0);
    }


    @Override
    @Transactional
    public void clear() {
        em.createQuery("delete from Member m");
    }
}
