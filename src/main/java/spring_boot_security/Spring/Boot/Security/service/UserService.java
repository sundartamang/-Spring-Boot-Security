package spring_boot_security.Spring.Boot.Security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import spring_boot_security.Spring.Boot.Security.model.Users;
import spring_boot_security.Spring.Boot.Security.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return  userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(auth.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        return  "Fail";
    }
}
