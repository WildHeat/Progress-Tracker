package com.progresstracker.ProgressTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progresstracker.ProgressTracker.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long>{
	

}
