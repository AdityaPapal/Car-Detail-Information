package com.carInformation.Project.exception;


import com.carInformation.Project.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ApiResponse> responseResourceNotFoundException(
            ResourceNotFoundException ex ){

            String message =ex.getMessage();

            ApiResponse apiResponse = new ApiResponse(message,false);

            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

}
