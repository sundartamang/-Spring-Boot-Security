package spring_boot_security.Spring.Boot.Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_boot_security.Spring.Boot.Security.model.Users;
import spring_boot_security.Spring.Boot.Security.service.UserService;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Welcome to spring boot " + request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public Object getCSRFToken(HttpServletRequest request){
        return request.getAttribute("_csrf");
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user){
        System.out.println("User is  "+ user);
        return userService.register(user);
    }
}
