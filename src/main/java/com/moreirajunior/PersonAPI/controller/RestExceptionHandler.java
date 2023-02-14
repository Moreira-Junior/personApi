package com.moreirajunior.PersonAPI.controller;

import com.moreirajunior.PersonAPI.appLogger.AppLogger;
import com.moreirajunior.PersonAPI.exceptions.AddressNotFoundException;
import com.moreirajunior.PersonAPI.exceptions.BadRequestExceptionInfo;
import com.moreirajunior.PersonAPI.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Logger;

@ControllerAdvice
public class RestExceptionHandler  {

    private static final Logger LOGGER = AppLogger.getAppLogger();

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> personNotFound(PersonNotFoundException personNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(personNotFoundException);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<Object> addressNotFound(AddressNotFoundException addressNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(addressNotFoundException);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> invalidRequest(MethodArgumentNotValidException methodArgumentNotValidException) {
        LOGGER.warning("Bad request: " + methodArgumentNotValidException.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestExceptionInfo()
                .title(methodArgumentNotValidException.getTitleMessageCode())
                .status(HttpStatus.BAD_REQUEST.value()).build());
    }

}
