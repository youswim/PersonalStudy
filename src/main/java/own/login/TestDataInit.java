package own.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import own.login.domain.Grade;
import own.login.domain.Item;
import own.login.domain.Member;
import own.login.repository.MemberRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TestDataInit {


    @PersistenceContext
    EntityManager em;
    private final MemberRepository memberRepository;

//    @PostConstruct
//    public void init() {
//        memberRepository.save(new Member("qwe", "qwe", Grade.USER));
//        memberRepository.save(new Member("asd", "asd", Grade.ADMIN));
//
//        Item item = new Item();
//        item.setCreated(LocalDateTime.now());
//        EntityTransaction tx = em.getTransaction();
//
//
//
//    }
}
