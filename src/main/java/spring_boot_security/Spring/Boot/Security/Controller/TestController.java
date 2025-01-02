package spring_boot_security.Spring.Boot.Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Welcome to spring boot " + request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public Object getCSRFToken(HttpServletRequest request){
        return request.getAttribute("_csrf");
    }
}
