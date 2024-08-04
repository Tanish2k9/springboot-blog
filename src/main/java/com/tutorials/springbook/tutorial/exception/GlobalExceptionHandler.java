package com.tutorials.springbook.tutorial.exception;

import com.tutorials.springbook.tutorial.constants.ExceptionConstant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistException.class)
    public ApiError handleUserAlreadyExistException(UserAlreadyExistException ex){
        ApiError apiError = new ApiError();
        apiError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiError.setErrors(List.of(ex.getMessage()));
        return apiError;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IncorrectCredentialsExcpetion.class)
    public ApiError handleIncorrectCredentialsException(IncorrectCredentialsExcpetion ex){
        ApiError apiError = new ApiError();
        apiError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiError.setErrors(List.of(ex.getMessage()));
        return apiError;
    }


//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(RuntimeException.class)
//    public ApiError handleRuntimeException(RuntimeException ex){
//        ApiError apiError = new ApiError();
//
//        if(ex instanceof io.jsonwebtoken.ExpiredJwtException){
//            apiError.setStatusCode(HttpStatus.UNAUTHORIZED.value());
//            apiError.setErrors(List.of("expired jwt token"));
//
//        }else {
//            apiError.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            apiError.setErrors(List.of(ex.getLocalizedMessage()));
//            ex.printStackTrace();
//        }
//        return apiError;
//    }

}
