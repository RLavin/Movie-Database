package com.ironyard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

/**
 * Created by Raul on 10/28/16.
 */
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = Throwable.class)
    public String handleBaseException(Throwable e){
        return e.getMessage();
    }

    @ExceptionHandler(value = SQLException.class)
    public String handleSQLException(Exception e){return e.getMessage();}
}
