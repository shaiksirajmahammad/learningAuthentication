package BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Security;

import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerUserDetails implements UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByName(username).orElseThrow(()->new UsernameNotFoundException("user name not found"));
    }
}
