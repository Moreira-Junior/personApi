package com.moreirajunior.PersonAPI.exceptions;

import java.time.LocalDateTime;

public class BadRequestExceptionInfo {

    private BadRequestException badRequestException = new BadRequestException("Bad request!");

    private String title;
    private int status;
    private LocalDateTime timestamp = LocalDateTime.now();

    public BadRequestExceptionInfo title(String title){
        this.badRequestException.setTitle(title);
        return this;
    }

    public BadRequestExceptionInfo status(int status){
        this.badRequestException.setStatus(status);
        return this;
    }

    public BadRequestException build(){
        return this.badRequestException;
    }
}
