package own.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import own.login.domain.Grade;
import own.login.domain.Member;
import own.login.repository.MemberRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        memberRepository.save(new Member("qwe", "qwe", Grade.USER));
        memberRepository.save(new Member("asd", "asd", Grade.ADMIN));

    }
}
