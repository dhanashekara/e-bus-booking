package com.ebus.booking.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookingException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(BookingException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setStatus("FAILURE");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
