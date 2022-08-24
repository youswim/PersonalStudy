package own.login.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import own.login.domain.Grade;
import own.login.domain.Member;
import own.login.form.MemberJoinForm;
import own.login.form.MemberLoginForm;
import own.login.service.MemberService;
import own.login.session.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        System.out.println("LoginController.loginPage");
        model.addAttribute("memberLoginForm", new MemberLoginForm());
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
    public String loginRequest(@Validated @ModelAttribute MemberLoginForm form,
                               BindingResult bindingResult,
                               HttpServletRequest req,
                               RedirectAttributes ra) {

        if (bindingResult.hasErrors()) {
            log.info("bindingResult={}", bindingResult);
            return "login-form";
        }

        Member member = new Member(form.getLoginId(), form.getLoginPasswd());

        Member checkedMember = memberService.checkMember(member);

        if (checkedMember == null) {
            bindingResult.reject("loginFail");
            log.info("bindingResult={}", bindingResult);
            return "login-form";
        }
//        화면 렌더링 시, MEMBER.GRADE 를 사용하기 위해 memberService에서 member를 찾아온다.
        ra.addFlashAttribute("member", checkedMember);

        if (checkedMember.getGrade() == Grade.ADMIN)
            ra.addFlashAttribute("members", memberService.findAll());

        HttpSession session = req.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, checkedMember);
//            new RedirectView("/login-home", true);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String joinPage(Model model) {
        model.addAttribute("memberJoinForm", new MemberJoinForm());
        return "signup-form";
    }

    @PostMapping("/new")
    public String joinRequest(@Validated @ModelAttribute MemberJoinForm form, BindingResult bindingResult) {

//        if (bindingResult.hasErrors()) {
//            log.info("bindingResult={}", bindingResult);
//            return "/signup-form";
//        }
        Member member = new Member(form.getLoginId(), form.getLoginPasswd(), form.getGrade());
        Member savedMember = memberService.save(member);
        if (savedMember == null) {
            bindingResult.rejectValue("loginId", "overlap");
            log.info("bindingResult={}", bindingResult);
            return "/signup-form";
        }
        return "redirect:/member/login";
    }

    @PostMapping("logout")
    public String logout(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
