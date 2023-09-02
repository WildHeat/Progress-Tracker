package com.progresstracker.ProgressTracker.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
import com.progresstracker.ProgressTracker.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
	}

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User tempUser = userService.addUser(user);
		if (tempUser == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<User> editUser(@RequestBody User user) {
		User tempUser = userService.editUser(user);
		if(tempUser == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteEmployeeById(@PathVariable long id) {
		userService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
	}

	@GetMapping("/user-details")
	public ResponseEntity<User> getUser(@AuthenticationPrincipal User user) {
		user.setPassword(null);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
