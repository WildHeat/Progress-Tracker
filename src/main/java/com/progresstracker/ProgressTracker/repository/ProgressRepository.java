package com.progresstracker.ProgressTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progresstracker.ProgressTracker.model.User;

public interface ProgressRepository extends JpaRepository<User, Long>{

}
