package com.ecom.Franchisee.controller;

import com.ecom.Franchisee.Error;
import com.ecom.Franchisee.exception.FranchiseeNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FranchiseeControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FranchiseeNotFoundException.class)
    public final Error handleFranchiseeNotFoundException(){
        return new Error(404,"Franchisee not found");
    }

}
