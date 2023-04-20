package com.example.teacherspringwebapp.restcontroler;


import com.example.teacherspringwebapp.restcontroler.dto.response.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex) {
        ResponseDto errorDetails = new ResponseDto();
        errorDetails.setMessage("Unexpected error occured");
        errorDetails.setCode(-1);

        log.error(ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}