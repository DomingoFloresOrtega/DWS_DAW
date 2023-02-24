package com.examen.examen4domingo.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id) {
        super("Not found Product with id: " + id);
    }
}
