package BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/home")
public class Home {
    @GetMapping("/welcome")
    public ResponseEntity<String> display(){
        System.out.println("api hit");
        return ResponseEntity.ok().body( "welcome to home page");
    }

}
