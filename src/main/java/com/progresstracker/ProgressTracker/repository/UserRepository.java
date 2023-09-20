package com.progresstracker.ProgressTracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progresstracker.ProgressTracker.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsernameIgnoreCase(String username);

}
