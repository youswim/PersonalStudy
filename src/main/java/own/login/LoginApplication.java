package own.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import own.login.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Slf4j
@Component
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

        Member[] members = new Member[55];
        for (int i = 0; i < 55; i++) {
            Member member3 = new Member(null, "yusiw", null);
            System.out.println("i = " + i);
            em.persist(member3);
        }


        System.out.println("============persist============");
//        em.persist(member1);
//        em.persist(member2);
//        em.persist(member3);
        System.out.println("============end============");
        test1();
    }

//    @Transactional
    public void test1() {

        Member member = new Member(null, "yusiw", null);
//
//        em.persist(member);
    }

    public void test2() {

        Member member = new Member(null, "yusiw", null);

        em.persist(member);
    }
}
