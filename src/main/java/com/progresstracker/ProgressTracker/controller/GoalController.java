package com.progresstracker.ProgressTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progresstracker.ProgressTracker.model.Goal;
import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.service.GoalService;

@RestController
@RequestMapping("/api/v1/goals")
public class GoalController {

	@Autowired
	private GoalService goalService;

	@GetMapping()
	public ResponseEntity<List<Goal>> getAllGoals() {
		return ResponseEntity.ok(goalService.getAllGoals());
	}

	@PutMapping()
	public ResponseEntity<Goal> updateGoal(@AuthenticationPrincipal User user, @RequestBody Goal goal) {
		return ResponseEntity.ok(goalService.updateGoal(goal, user));
	}
	
	@PostMapping()
	public ResponseEntity<Goal> addGoal(@RequestBody Goal goal){
		return ResponseEntity.ok(goalService.addGoal(goal));		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Goal> deleteGoalById(@PathVariable long id, @AuthenticationPrincipal User user) {
		goalService.deleteById(id, user);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Goal> getGoalById(@PathVariable long id, @AuthenticationPrincipal User user){
		return ResponseEntity.status(HttpStatus.OK).body(goalService.getGoalById(id));
	}
	
	
}
