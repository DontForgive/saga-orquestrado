package br.com.microservices.orchestrated.inventoryservice.config.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(ValidationsException.class)
    public ResponseEntity<?> handleValidationException(ValidationsException validationsException){
        var details = new ExceptionDetails(HttpStatus.BAD_REQUEST.value(),validationsException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}
