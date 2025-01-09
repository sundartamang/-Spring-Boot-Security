package spring_boot_security.Spring.Boot.Security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring_boot_security.Spring.Boot.Security.model.UserPrinciple;
import spring_boot_security.Spring.Boot.Security.model.Users;
import spring_boot_security.Spring.Boot.Security.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);

        if (user == null) {
            System.out.println("User not found ");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrinciple(user);
    }
}
