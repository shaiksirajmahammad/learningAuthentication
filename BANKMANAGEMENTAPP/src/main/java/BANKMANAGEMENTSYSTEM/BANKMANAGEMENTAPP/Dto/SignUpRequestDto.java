package BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Dto;

//import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Annotation.Email;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
//@jakarta.validation.constraints.Email

@Data
public class SignUpRequestDto {

    @NotBlank(message = "not be blank")
//    @Pattern(
//            regexp = "^[A-Za-z0-9+_.-]+@(" +
//                    "yahoo\\.com|" +
//                    "[A-Za-z0-9.-]+\\.org|" +
//                    "[A-Za-z0-9.-]+\\.in" +
//                    ")$",
//            message = "Email must end with .org, .in, or be yahoo.com"
//    )
    String email;
    String password;

    private String gender;

    private LocalDate dob;

    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid phone number")
    private String phoneNo;

    @Pattern(regexp = "^[2-9][0-9]{11}$", message = "Invalid Aadhaar Number")
    private String aadhaar;

}
