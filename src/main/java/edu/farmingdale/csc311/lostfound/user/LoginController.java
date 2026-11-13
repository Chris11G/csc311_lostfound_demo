package edu.farmingdale.csc311.lostfound.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Spring Security handles POST /login; we only serve the page
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
