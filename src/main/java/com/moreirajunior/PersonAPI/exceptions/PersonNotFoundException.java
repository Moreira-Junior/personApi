package com.moreirajunior.PersonAPI.exceptions;

import java.time.LocalDateTime;

public class PersonNotFoundException extends RuntimeException{

    private String message = "Person was not found!";
    private int status = 404;
    private LocalDateTime timestamp = LocalDateTime.now();

    @Override
    public String getMessage(){
        return this.message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
