package th.mfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/admin";
        //// must login before close google chrome///
    }
}
