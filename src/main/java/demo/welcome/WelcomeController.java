package demo.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "hello world!";
    }

    @RequestMapping("/todo")
    public String todo() {
        return "todo";
    }
}
