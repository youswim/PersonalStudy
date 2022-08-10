package own.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import own.login.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Slf4j
@SpringBootApplication
public class LoginApplication implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//
//        Member member = new Member();
//        member.setLoginId("yusiw");
//        member.setLoginPasswd("23123");
//        em.persist(member);
//

    }
}
