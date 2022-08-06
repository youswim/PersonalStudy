package own.login.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.RequestContextUtils;
import own.login.domain.Member;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homeIndex() {
        return "/index";
    }

//    @GetMapping("/login-home")
//    public String loginHome(@ModelAttribute Object member) {
//        return "login-home";
//    }

    @GetMapping("/login-home")
    public String loginHome(HttpServletRequest req) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);
        if (inputFlashMap != null) {
            Member member = (Member) inputFlashMap.get("member");
            return "login-home";
        }
        else
            return "login-form";
    }

}
