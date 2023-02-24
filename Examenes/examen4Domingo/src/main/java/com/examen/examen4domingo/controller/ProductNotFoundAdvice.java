package com.examen.examen4domingo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class ProductNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(com.examen.examen4domingo.exception.ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(com.examen.examen4domingo.exception.ProductNotFoundException productNotFoundException) {
        return productNotFoundException.getMessage();
    }

}
