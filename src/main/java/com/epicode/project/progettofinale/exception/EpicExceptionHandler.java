package com.epicode.project.progettofinale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class EpicExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiError error){
        return new ResponseEntity<>(error,error.getStatus());
    }


    @ExceptionHandler(EpicException.class)
    protected ResponseEntity<Object> handleEpicException(EpicException exc){
        ApiError error=new ApiError(exc.getMessage(), HttpStatus.BAD_REQUEST);

        return buildResponseEntity(error);

    }
}
