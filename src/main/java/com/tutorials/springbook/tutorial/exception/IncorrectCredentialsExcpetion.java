package com.tutorials.springbook.tutorial.exception;

public class IncorrectCredentialsExcpetion extends RuntimeException {

    public IncorrectCredentialsExcpetion(String message){
        super(message);
    }
}
