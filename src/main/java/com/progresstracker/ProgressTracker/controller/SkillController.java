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

import com.progresstracker.ProgressTracker.model.Skill;
import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.service.SkillService;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@GetMapping()
	public ResponseEntity<List<Skill>> getAllSkills() {
		return ResponseEntity.ok(skillService.getAllSkills());
	}

	@PutMapping()
	public ResponseEntity<Skill> updateSkill(@AuthenticationPrincipal User user, @RequestBody Skill skill) {
		return ResponseEntity.ok(skillService.updateSkill(skill));
	}
	
	@PostMapping()
	public ResponseEntity<Skill> addSkill(@RequestBody Skill skill){
		return ResponseEntity.ok(skillService.addSkill(skill));		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Skill> deleteSkillById(@PathVariable long id) {
		skillService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Skill> getSkillById(@PathVariable long id, @AuthenticationPrincipal User user){
		return ResponseEntity.status(HttpStatus.OK).body(skillService.getSkillById(id, user));
	}
	
	
}
