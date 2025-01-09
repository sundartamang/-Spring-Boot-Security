package spring_boot_security.Spring.Boot.Security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot_security.Spring.Boot.Security.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
