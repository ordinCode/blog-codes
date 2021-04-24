package blog.ordincode.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController implements ErrorController {
    @GetMapping({"/", "/error"})
    public String index() {
        return "index";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/info")
    public String info() {
        return "info";
    }
}
