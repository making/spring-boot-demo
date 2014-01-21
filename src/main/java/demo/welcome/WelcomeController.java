package demo.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import java.time.LocalDateTime;

@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("now",
                /*LocalDateTime.now()*/ new java.util.Date());
        return "welcome";
    }

    @RequestMapping("/actuator")
    public String actuator() {
        return "actuator";
    }
}
