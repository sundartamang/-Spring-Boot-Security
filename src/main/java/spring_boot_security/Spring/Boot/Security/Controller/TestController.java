package spring_boot_security.Spring.Boot.Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spring_boot_security.Spring.Boot.Security.model.Users;
import spring_boot_security.Spring.Boot.Security.service.UserService;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Welcome to spring boot " + request.getSession().getId();
    }

    @GetMapping("/admin-role")
    @PreAuthorize("hasRole('ADMIN')")
    public String greetAdmin(HttpServletRequest request) {
        return " This is admin role " + request.getSession().getId();
    }

    @GetMapping("/manager-role")
    @PreAuthorize("hasRole('MANAGER', 'ADMIN')")
    public String greetManager(HttpServletRequest request) {
        return "Welcome to the manager role " + request.getSession().getId();
    }

    @GetMapping("/admin-manager-role")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public String greetAdminAndManager(HttpServletRequest request){
        return "Welcome to the admin and manager role " + request.getSession().getId();
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
        System.out.println("User is  " + user);
        return userService.register(user);
    }

    @PostMapping("/user-login")
    public String loginUser(@RequestBody Users user) {
        return userService.verify(user);
    }
}
