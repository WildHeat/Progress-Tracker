package com.progresstracker.ProgressTracker.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.progresstracker.ProgressTracker.exception.InvalidCredentialsException;
import com.progresstracker.ProgressTracker.exception.UserNotFoundException;
import com.progresstracker.ProgressTracker.exception.UsernameAlreayExistsException;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(value = UsernameAlreayExistsException.class)
	public ResponseEntity<String> handleUsernameAlreadyExistsException(UsernameAlreayExistsException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	
	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentialsException e){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(InvalidCredentialsException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		List<ObjectError> objectErrors = e.getAllErrors();
		
		StringBuilder errors = new StringBuilder();
		
		objectErrors.forEach(error -> errors.append(error.getDefaultMessage()+", "));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());
	}
	
	
}
