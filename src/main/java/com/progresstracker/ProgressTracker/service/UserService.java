package com.progresstracker.ProgressTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.repository.UserRepository;
import com.progresstracker.ProgressTracker.util.CustomPasswordEncoder;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomPasswordEncoder customPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User addUser(User user) {
		System.out.println("Adding user - \n" + user.toString());
		if (userRepository.existsById(user.getId())) {
			return null;
		}
		user.setPassword(customPasswordEncoder.getPasswordEncoder().encode(user.getPassword()));
		System.out.println("Saving user - \n" + user.toString());
		return userRepository.save(user);
	}

	public User editUser(User user) {
		Optional<User> optionalUser = userRepository.findById(user.getId());
		if (optionalUser.isPresent()) {
			user.setPassword(optionalUser.get().getPassword());
			
			return userRepository.save(user);
		}
		return null;
	}

	public void deleteById(long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}
	}

	public User getUserById(long id) {
		Optional<User> optionalEmployee = userRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		return null;
	}

}
