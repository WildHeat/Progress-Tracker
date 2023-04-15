package com.progresstracker.ProgressTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.repository.ProgressRepository;

@Service
public class ProgressService {
	
	private ProgressRepository progressRepository;

	@Autowired
	public ProgressService(ProgressRepository progressRepository) {
		super();
		this.progressRepository = progressRepository;
	}
	
	public List<User> getAllUsers(){
		return progressRepository.findAll();
	}
	
	public User addUser(User user) {
		if(progressRepository.existsById(user.getId())) {
			return null;
		}
		return progressRepository.save(user);
	}
	public User editUser(User user) {
		if(progressRepository.existsById(user.getId())) {
			return progressRepository.save(user);
		}
		return null;
	}
	
	public void deleteById(long id) {
		if(progressRepository.existsById(id)) {
			progressRepository.deleteById(id);			
		}
	}
	
	public User getUserById(long id) {
		Optional<User> optionalEmployee = progressRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		return null;
	}


}
