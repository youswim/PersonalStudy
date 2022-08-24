package own.login.controller;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.support.RequestContextUtils;
import own.login.domain.Grade;
import own.login.domain.Member;
import own.login.form.MemberLoginForm;
import own.login.service.MemberService;
import own.login.session.SessionConst;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @GetMapping("/")
    public String loginHome(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Member member,
            HttpServletRequest req, Model model) {
//
//        if (member != null) {
//
//        }
//        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);
//
//        if (inputFlashMap == null || !inputFlashMap.containsKey("member")) {
//            model.addAttribute("member", null);
//        }
//        Member member = (Member) inputFlashMap.get("member");
        model.addAttribute("member", member);
        if (member != null && member.getGrade() == Grade.ADMIN) {
            model.addAttribute("members", memberService.findAll());
        }
        System.out.println("member = " + member);
        return "login-home";
    }
    @GetMapping("/index")
    public String homeIndex() {
        return "index";
    }

}