package com.moreirajunior.PersonAPI.exceptions;

public class PersonNotFoundException extends RuntimeException{

    private String message = "Person was not found!";

    @Override
    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
