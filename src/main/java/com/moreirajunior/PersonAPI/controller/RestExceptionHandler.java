package com.moreirajunior.PersonAPI.controller;

import com.moreirajunior.PersonAPI.appLogger.AppLogger;
import com.moreirajunior.PersonAPI.exceptions.AddressNotFoundException;
import com.moreirajunior.PersonAPI.exceptions.BadRequestException;
import com.moreirajunior.PersonAPI.exceptions.BadRequestExceptionInfo;
import com.moreirajunior.PersonAPI.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Logger;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = AppLogger.getAppLogger();

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> personNotFound(){
        String exceptionMessage = new PersonNotFoundException().getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionMessage);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<Object> addressNotFound(){
        String exceptionMessage = new AddressNotFoundException().getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    //TODO find a way to handle the @valid exception from spring
    public ResponseEntity<Object> badRequest(BadRequestException badRequestException) {
        LOGGER.warning("Bad request " + badRequestException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestExceptionInfo()
                .title(badRequestException.getMessage())
                .status(HttpStatus.BAD_REQUEST.value()).build());
    }

}
