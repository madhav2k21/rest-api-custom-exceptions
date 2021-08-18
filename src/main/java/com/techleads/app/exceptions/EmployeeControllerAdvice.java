package com.techleads.app.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
public class EmployeeControllerAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, APIError> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, APIError> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();

			errors.put(fieldName,
					new APIError("Bad Request", String.valueOf(HttpStatus.BAD_REQUEST.value()), errorMessage));
		});
		return errors;
	}

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<APIError> HandleEmployeeNotFoundException(InvalidFormatException exp) {

		APIError error = new APIError("Please enter a number value for Id field", "400", exp.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<APIError> HandleEmployeeNotFoundException(EmployeeNotFound exp) {

		APIError error = new APIError("Employee not found with the given id", "400");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
