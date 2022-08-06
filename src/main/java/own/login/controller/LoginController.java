package own.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import own.login.domain.Member;
import own.login.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Enumeration;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberRepository memberRepository;

    @GetMapping("/login")
    public String loginPage() {
        System.out.println("LoginController.loginPage");
        return "login-page";
    }

    @PostMapping("/login")
    public String loginRequest(@ModelAttribute Member member) {
        System.out.println("LoginController.loginRequest");
        if (memberRepository.findByLoginID(member)) {
            System.out.println("foundMember!!!");
            return "home-page";
        }
        else
            return "redirect:/login";
    }

    @GetMapping("/new")
    public String joinPage() {
        System.out.println("LoginController.joinPage");
        return "signup-page";
    }

    @PostMapping("/new")
    public String joinRequest(@ModelAttribute Member member) {
        System.out.println("LoginController.joinRequest");
        System.out.println("member = " + member);
        memberRepository.save(member);
        return "redirect:/login";
    }
}
