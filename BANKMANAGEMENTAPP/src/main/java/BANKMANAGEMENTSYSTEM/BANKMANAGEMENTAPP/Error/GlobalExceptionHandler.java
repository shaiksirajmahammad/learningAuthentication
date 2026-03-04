package BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Error;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(JwtException.class)
//    public ResponseEntity<ApiError> handleUsernameNotFoundException(JwtException usernameNotFoundException){
//        ApiError apiError=new ApiError("hacker", HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(apiError,apiError.getStatusCode());
//    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiError>handleUsernameNotFoundException(Exception usernameNotFoundException){
//        ApiError apiError=new ApiError("user not found with username", HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(apiError,apiError.getStatusCode());
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError>handleArgument(MethodArgumentNotValidException methodArgumentNotValidException){
        ApiError apiError=new ApiError("email must contain the given{} rules",HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError>handleMultiSignUp(IllegalArgumentException illegalArgumentException){
        ApiError apiError=new ApiError("user already exist",HttpStatus.ALREADY_REPORTED);
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(apiError);
    }
    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError>handleJwtError(JwtException exception){
        ApiError apiError=new ApiError("jwt error",HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError>handleMultiSignUp(Exception exception){
        ApiError apiError=new ApiError("unexpected exception occurs",HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
