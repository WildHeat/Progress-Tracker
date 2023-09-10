package com.progresstracker.ProgressTracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
}
