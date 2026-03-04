package BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Controller;

import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Dto.LoginRequestDto;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Dto.LoginResponseDto;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Dto.SignUpRequestDto;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Dto.SignUpResponseDto;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Security.AuthSecurity;
import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:3000")

@RequiredArgsConstructor
@Slf4j
public class Authentication {
    private final AuthenticationService authenticationService;
    private final AuthSecurity authSecurity;
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto>signup(@RequestBody @Valid SignUpRequestDto signUpRequestDto){
//        log.info("incoming request: {}", request.getRequestURI());
        System.out.println("api hit");
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.signUp(signUpRequestDto));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto>login(@RequestBody LoginRequestDto loginRequestDto){
        System.out.println("loginhit");
        return ResponseEntity.status(HttpStatus.OK).body(authSecurity.login(loginRequestDto));

    }

}
