package own.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import own.login.domain.Member;
import own.login.repository.ItemRepository;
import own.login.repository.MemberRepository;

import javax.transaction.Transactional;

@Slf4j
@Component
@SpringBootApplication
public class LoginApplication implements CommandLineRunner {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        test1();
//        test2();
    }

    private void test1() {
        Member member3 = new Member(null, "yusiw", null);
        memberRepository.save(member3);
        memberRepository.deleteAll();
    }

    private void test2() {
        Member[] members = new Member[55];
        for (int i = 0; i < 55; i++) {
            Member member3 = new Member(null, "yusiw", null);
            System.out.println("i = " + i);
            memberRepository.save(member3);
        }
    }
}
