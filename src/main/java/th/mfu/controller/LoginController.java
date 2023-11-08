package th.mfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
	@GetMapping("/login")
	String login() {
		return "login";
	}
}
    // @GetMapping("/login?logout")
    // public String logoutSuccess() {
    //     return "logout-success"; // You can define a custom logout success template
    // }

