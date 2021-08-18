package com.techleads.app.exceptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
public class EmployeeControllerAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {MethodArgumentNotValidException.class,ConstraintViolationException.class})
	public Map<String, APIError> handleValidationExceptions(MethodArgumentNotValidException ex, MethodArgumentNotValidException mae) {
		Map<String, APIError> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();

			errors.put(fieldName,
					new APIError("Bad Request", String.valueOf(HttpStatus.BAD_REQUEST.value()), errorMessage));
		});
		return errors;
	}

	@ExceptionHandler(value = {InvalidFormatException.class, HttpMessageNotReadableException.class})
	public ResponseEntity<APIError> HandleEmployeeNotFoundException(InvalidFormatException exp) {

		APIError error = new APIError("Please enter a number value for Id field", "400", exp.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(LocationFieldNotFoundException.class)
//	public ResponseEntity<APIError> HandleLocationFieldNotFoundException(LocationFieldNotFoundException exp) {
//
//		APIError error = new APIError("Bad Request", "400", exp.getMessage(), Arrays.asList("HYD","CHN","BNG"));
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler(LocationFieldNotFoundException.class)
	public ResponseEntity<Map<String, APIError>> HandleLocationFieldNotFoundException(
			LocationFieldNotFoundException exp) {

		Map<String, APIError> error = new HashMap<>();
		error.put("location", new APIError("Bad Request", "400", exp.getMessage(), Arrays.asList("HYD", "CHN", "BNG")));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<APIError> HandleEmployeeNotFoundException(EmployeeNotFound exp) {

		APIError error = new APIError("Employee not found with the given id", "400");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MemberNumberInvalidException.class)
	public ResponseEntity<Map<String, APIError>> handleMemberNumberInvalidException(
			MemberNumberInvalidException exp) {
		Map<String, APIError> error = new HashMap<>();
		error.put("memberNo", new APIError("Bad Request", "400", exp.getMessage(), "Please enter only number value"));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<Map<String, APIError>> handleMissingRequestHeaderException(
			MissingRequestHeaderException exp) {
		Map<String, APIError> error = new HashMap<>();
		error.put(exp.getHeaderName(), new APIError("Bad Request", "400", exp.getMessage()));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
