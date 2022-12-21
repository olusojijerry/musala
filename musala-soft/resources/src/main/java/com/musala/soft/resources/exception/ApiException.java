package com.musala.soft.resources.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
