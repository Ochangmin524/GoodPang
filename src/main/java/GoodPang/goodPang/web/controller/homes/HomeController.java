package GoodPang.goodPang.web.controller.homes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/login")
    public String login(Model model) {
        return "members/login";
    }

    @GetMapping("/loginHome")
    public String home(Model model) {

        return "redirect:/items/search";
    }

    }


