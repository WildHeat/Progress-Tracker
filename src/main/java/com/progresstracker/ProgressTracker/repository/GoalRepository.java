package com.progresstracker.ProgressTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progresstracker.ProgressTracker.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long>{

}
