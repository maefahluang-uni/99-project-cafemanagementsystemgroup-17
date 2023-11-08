package th.mfu.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/admin";
        }
        return "/login";
    }
    // @GetMapping("/login?logout")
    // public String logoutSuccess() {
    //     return "logout-success"; // You can define a custom logout success template
    // }
}
