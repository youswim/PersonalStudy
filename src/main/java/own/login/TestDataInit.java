package own.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import own.login.domain.Grade;
import own.login.domain.Item;
import own.login.domain.Member;
import own.login.repository.ItemRepository;
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


    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        memberRepository.save(new Member("qwe", "qwe", Grade.USER));
        memberRepository.save(new Member("asd", "asd", Grade.ADMIN));

        itemRepository.save(new Item(null, "apple", 10000, 2000, "맛좋은 사과"));
        itemRepository.save(new Item(null, "banana", 2000, 10000, "단맛 가득 바나나"));
    }
}
