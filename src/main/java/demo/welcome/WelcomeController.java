package demo.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("now",
                new Date());
        return "welcome";
    }

    @RequestMapping("/actuator")
    public String actuator() {
        return "actuator";
    }
}
