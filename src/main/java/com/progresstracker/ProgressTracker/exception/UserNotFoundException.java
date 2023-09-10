package com.progresstracker.ProgressTracker.exception;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 6272080093476061426L;
	
	public UserNotFoundException() {
		super("User not found");
	}

}
