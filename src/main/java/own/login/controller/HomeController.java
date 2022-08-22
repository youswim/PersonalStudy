package own.login.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.RequestContextUtils;
import own.login.domain.Member;
import own.login.form.MemberLoginForm;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {


    @GetMapping("/")
    public String loginHome(HttpServletRequest req, Model model) {

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);

        if (inputFlashMap == null || !inputFlashMap.containsKey("member")) {
            model.addAttribute("member", null);
        }
//        Member member = (Member) inputFlashMap.get("member");
        return "login-home";
    }
    @GetMapping("/index")
    public String homeIndex() {
        return "index";
    }

}