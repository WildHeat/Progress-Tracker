package com.progresstracker.ProgressTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progresstracker.ProgressTracker.model.ExpEntry;
import com.progresstracker.ProgressTracker.model.Goal;
import com.progresstracker.ProgressTracker.model.Skill;
import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.repository.ExpEntryRepository;
import com.progresstracker.ProgressTracker.repository.GoalRepository;

@Service
public class GoalService {

	@Autowired
	private GoalRepository goalRepository;

	public List<Goal> getAllGoals() {
		return goalRepository.findAll();
	}

	public Goal updateGoal(Goal goal, User user) {
		if (!goalRepository.existsById(goal.getId())) {
			return null;
		}
		for (Skill skill : user.getSkills()) {
			for (Goal goa : skill.getGoals()) {
				if(goa.getId() == goal.getId()) {
					return goalRepository.save(goal);
				}
			}
		}
		return null;
	}

	public Goal addGoal(Goal goal) {
		return goalRepository.save(goal);
	}

	public void deleteById(long id, User user) {
		Optional<Goal> optionalGoal = goalRepository.findById(id);
		if (!optionalGoal.isPresent()) {
			return;
		}
		
		for (Skill skill : user.getSkills()) {
			for (Goal goa : skill.getGoals()) {
				if(goa.getId() == optionalGoal.get().getId()) {					
					goalRepository.deleteById(id);
					return;
				}
			}
		}
		

	}

	public Goal getGoalById(long id) {
		Optional<Goal> optionalGoal = goalRepository.findById(id);
		if (optionalGoal.isPresent()) {
			return optionalGoal.get();
		}
		return null;
	}

}
