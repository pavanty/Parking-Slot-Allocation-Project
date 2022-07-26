package com.example.psap.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalValidationHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleResourseNotFoundException(UserNotFoundException exec) {

        return new ResponseEntity<String>(exec.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DuplicateParkingFloorException.class)
    public ResponseEntity<String> handleDuplicateUserException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("We this user already, please enter some other details", HttpStatus.NOT_ACCEPTABLE);
        return responseEntity;
    }


    @ExceptionHandler(value = NoSuchVehicleException.class)
    public ResponseEntity<String> handleNoSuchVehicleException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("No Such Vehicle Found", HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = DuplicateVehicleException.class)
    public ResponseEntity<String> handleDuplicateVehicleException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Vehicle already Registered", HttpStatus.NOT_ACCEPTABLE);
        return responseEntity;
    }


    @ExceptionHandler(value = NotificationException.class)
    public ResponseEntity<String> handleNotificationException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Notification Exeption please verify the user's email Id", HttpStatus.NOT_ACCEPTABLE);
        return responseEntity;
    }

}