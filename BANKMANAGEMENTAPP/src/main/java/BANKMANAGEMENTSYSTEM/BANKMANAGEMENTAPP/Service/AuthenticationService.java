package BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Service;

import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Dto.SignUpRequestDto;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Dto.SignUpResponseDto;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Entity.User;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        User user=userRepo.findByName(signUpRequestDto.getEmail()).orElse(null);
        if(user!=null)throw new IllegalArgumentException("user already exist");
        user=User.builder()
        .username(signUpRequestDto.getEmail())
                .password(passwordEncoder.encode( signUpRequestDto.getPassword()))
                .gender(signUpRequestDto.getGender())
                .phoneNo(signUpRequestDto.getPhoneNo())
                .aadhaarNo(signUpRequestDto.getAadhaar())
        .build();
        userRepo.save(user);
        return SignUpResponseDto.builder()
                .id(user.getId())
                .name( user.getUsername())
                .build();
    }
}
