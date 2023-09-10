package com.progresstracker.ProgressTracker.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progresstracker.ProgressTracker.exception.InvalidCredentialsException;
import com.progresstracker.ProgressTracker.exception.UserNotFoundException;
import com.progresstracker.ProgressTracker.exception.UsernameAlreayExistsException;
import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.repository.UserRepository;
import com.progresstracker.ProgressTracker.util.CustomPasswordEncoder;

@Service
public class UserService {

	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
	private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

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

	public User addUser(User user) throws UsernameAlreayExistsException, InvalidCredentialsException {
		System.out.println("Adding user - \n" + user.toString());

		Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());

		if (optionalUser.isPresent()) {
			throw new UsernameAlreayExistsException("Username: " + user.getUsername() + " already exists");
		}

		if (!pattern.matcher(user.getPassword()).matches()) {
			throw new InvalidCredentialsException("Password validation is not met");
		}

		user.setPassword(customPasswordEncoder.getPasswordEncoder().encode(user.getPassword()));
		System.out.println("Saving user - \n" + user.toString());
		return userRepository.save(user);
	}

	public User editUser(User user, User userFromJwt) throws InvalidCredentialsException, UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(user.getId());

		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException();
		}
		
		if (user.getId() != userFromJwt.getId()) {
			throw new InvalidCredentialsException("Incorrect token");
		}

		user.setPassword(optionalUser.get().getPassword());
		return userRepository.save(user);
		
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
