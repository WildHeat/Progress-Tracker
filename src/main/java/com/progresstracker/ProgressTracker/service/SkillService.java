package com.progresstracker.ProgressTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progresstracker.ProgressTracker.model.ExpEntry;
import com.progresstracker.ProgressTracker.model.Skill;
import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.repository.ExpEntryRepository;
import com.progresstracker.ProgressTracker.repository.SkillRepository;
import com.progresstracker.ProgressTracker.repository.UserRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	public Skill updateSkill(Skill skill, User user) {
		if (!skillRepository.existsById(skill.getId())) {
			return null;
		}
		
		for(Skill ski : user.getSkills()) {
			if (ski.getId() == skill.getId()) return skillRepository.save(skill);
		}
	
		return null;

	}

	public Skill addSkill(Skill skill) {
		return skillRepository.save(skill);
	}

	public void deleteById(long id) {
		Optional<Skill> optionalSkill = skillRepository.findById(id);
		if (optionalSkill.isPresent()) {
			System.out.println("Deleting skill-" + id);
			skillRepository.deleteById(id);
		}

	}

	public Skill getSkillById(long id, User user) {
		Optional<Skill> optionalSkill = skillRepository.findById(id);
		if (optionalSkill.isPresent()) {
			Skill skill = optionalSkill.get();
			for (Skill s : user.getSkills()) {
				if (s.getId() == skill.getId()) {
					return skill;
				}
			}

		}
		return null;
	}

}
