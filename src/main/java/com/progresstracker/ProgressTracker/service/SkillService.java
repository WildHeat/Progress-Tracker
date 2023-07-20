package com.progresstracker.ProgressTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progresstracker.ProgressTracker.model.ExpEntry;
import com.progresstracker.ProgressTracker.model.Skill;
import com.progresstracker.ProgressTracker.repository.ExpEntryRepository;
import com.progresstracker.ProgressTracker.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	public Skill updateSkill(Skill skill) {
		if (skillRepository.existsById(skill.getId())) {
			int newExp = 0;
			for (ExpEntry entry : skill.getExpEntries()) {
				newExp += entry.getExp();
			}
			skill.setExp(newExp);

			return skillRepository.save(skill);
		}
		return new Skill();
	}

	public Skill addSkill(Skill skill) {
		return skillRepository.save(skill);
	}

	public void deleteById(long id) {
		Optional<Skill> optionalSkill = skillRepository.findById(id);
		if (optionalSkill.isPresent()) {
			System.out.println("Deleting skill-" + id);
//			for (ExpEntry entry : optionalSkill.get().getExpEntries()) {
//				expEntryRepository.deleteById(entry.getId());
//			}
			skillRepository.deleteById(id);
		}

	}

	public Skill getSkillById(long id) {
		Optional<Skill> optionalSkill = skillRepository.findById(id);
		if (optionalSkill.isPresent()) {
			return optionalSkill.get();
		}
		return null;
	}

}
