package com.moreirajunior.PersonAPI.exceptions;

import java.time.LocalDateTime;

public class BadRequestExceptionInfo {

    private BadRequestException badRequestException;

    private String title;
    private int status;
    private LocalDateTime timestamp = LocalDateTime.now();

    public BadRequestExceptionInfo title(String title){
        this.title = title;
        return this;
    }

    public BadRequestExceptionInfo status(int status){
        this.status = status;
        return this;
    }

    public BadRequestException build(){
        return this.badRequestException;
    }
}
