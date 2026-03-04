package BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Security;

import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Dto.LoginRequestDto;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Dto.LoginResponseDto;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Entity.User;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthSecurity {
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final AuthUtil authUtil;
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
//        User user=userRepo.findByName(loginRequestDto.getEmail());
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),loginRequestDto.getPassword()));
        User user=(User)authentication.getPrincipal();
        String token=authUtil.generateAccessToken(user);
        return LoginResponseDto.builder()
                .id(user.getId())
                .jwt(token)
                .build();



    }
}
