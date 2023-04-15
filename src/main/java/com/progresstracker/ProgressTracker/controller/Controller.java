package com.progresstracker.ProgressTracker.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.service.ProgressService;

@RestController
@RequestMapping("/api/v1/users")
public class Controller {
	
	private ProgressService progressService;

	@Autowired
	public Controller(ProgressService progressService) {
		super();
		this.progressService = progressService;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(progressService.getAllUsers());
	}
	
	@PostMapping
	public ResponseEntity<User> addEmployee(@RequestBody User user){
		User tempUser = progressService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<User> editUser(@RequestBody User user) {
		User tempUser = progressService.editUser(user);
//		return ResponseEntity.status(HttpStatus.OK).body(tempEmployee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteEmployeeById(@PathVariable long id) {
		progressService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(progressService.getUserById(id));
	}
	

}
