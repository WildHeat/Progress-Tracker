package com.progresstracker.ProgressTracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.repository.UserRepository;
import com.progresstracker.ProgressTracker.util.CustomPasswordEncoder;


@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository progressRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> userOpt = progressRepository.findByUsername(username);
		return userOpt.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
	}

}
