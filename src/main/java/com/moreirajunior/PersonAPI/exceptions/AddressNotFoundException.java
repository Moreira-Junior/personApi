package com.moreirajunior.PersonAPI.exceptions;

public class AddressNotFoundException extends RuntimeException{

    private String message = "Address was not found!";

    @Override
    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
