package BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Entity;

import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Repo.UserRepo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
//    private final UserRepo userRepo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    private String gender;

    @Column(nullable = false,unique = true)
    private String phoneNo;

    @Column(nullable = false,unique = true)
    private String aadhaarNo;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
