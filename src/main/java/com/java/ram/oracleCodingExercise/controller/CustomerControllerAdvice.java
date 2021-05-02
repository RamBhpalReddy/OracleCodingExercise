package com.java.ram.oracleCodingExercise.controller;
/*COntroller Advice to give exception response in case of exception in controller*/
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.java.ram.oracleCodingExercise.Exception.DataException;
import com.java.ram.oracleCodingExercise.Exception.ErrorResponse;

@RestControllerAdvice
public class CustomerControllerAdvice {
	
	@ExceptionHandler(value = { DataException.class })
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ErrorResponse badRequest(DataException ex)
    {
        return new ErrorResponse(417, ex.getMessage());
    }  
}
