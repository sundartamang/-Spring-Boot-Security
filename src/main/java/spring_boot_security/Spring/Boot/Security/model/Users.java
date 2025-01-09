package spring_boot_security.Spring.Boot.Security.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Users {
    @Id
    private int id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_table",
        joinColumns = @JoinColumn(name = "users", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "roles", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();
}
