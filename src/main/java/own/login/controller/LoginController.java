package own.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import own.login.domain.Grade;
import own.login.domain.Member;
import own.login.service.MemberService;
import own.login.service.MemberServiceImpl;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginPage() {
        System.out.println("LoginController.loginPage");
        return "login-form";
    }

//    @PostMapping("/login")
//    public String loginRequest(@ModelAttribute Member member,RedirectAttributes ra) {
//        System.out.println("LoginController.loginRequest");
//        if (memberService.checkMember(member)) {
//            ra.addFlashAttribute("member", member);
//            return "redirect:/login-home";
//        }
//        return "redirect:/login";
//    }

    @PostMapping("/login")
    public RedirectView loginRequest(@ModelAttribute Member member, RedirectAttributes ra) {
        System.out.println("LoginController.loginRequest");
        if (memberService.checkMember(member)) {
            Member findMember = memberService.findByLoginId(member.getLoginId());
            // 화면 렌더링 시, MEMBER.GRADE 를 사용하기 위해 memberService에서 member를 찾아온다.
            ra.addFlashAttribute("member", findMember);
            if(findMember.getGrade() == Grade.ADMIN)
                ra.addFlashAttribute("members", memberService.findAll());
            return new RedirectView("/login-home", true);
        }
        return new RedirectView("/login", true);
    }



    @GetMapping("/new")
    public String joinPage() {
        System.out.println("LoginController.joinPage");
        return "signup-form";
    }

    @PostMapping("/new")
    public String joinRequest(@ModelAttribute Member member) {
        System.out.println("LoginController.joinRequest");
        memberService.save(member);
        return "redirect:/login";
    }
}
