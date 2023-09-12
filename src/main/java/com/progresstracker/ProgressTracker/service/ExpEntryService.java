package com.progresstracker.ProgressTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progresstracker.ProgressTracker.model.ExpEntry;
import com.progresstracker.ProgressTracker.model.Skill;
import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.repository.ExpEntryRepository;

@Service
public class ExpEntryService {
	
	@Autowired
	private ExpEntryRepository expEntryRepository; 

	public List<ExpEntry> getAllExpEntrys(){
		return expEntryRepository.findAll();
	}

	public ExpEntry updateExpEntry(ExpEntry expEntry) {
		if (expEntryRepository.existsById(expEntry.getId())) {		
			expEntry.setExp((int) (expEntry.getHours() * 50 * (expEntry.getFocus()/2.0)));
			return expEntryRepository.save(expEntry);
		}
		return new ExpEntry();
	}
	
	public ExpEntry addExpEntry(ExpEntry expEntry) {
		expEntry.setExp((int) (expEntry.getHours() * 50 * (expEntry.getFocus()/2.0)));
		return expEntryRepository.save(expEntry);
	}

	public void deleteById(long id, User user) {
		if (!expEntryRepository.existsById(id)) {
			return;
		}
		
		for(Skill skill : user.getSkills()) {
			for(ExpEntry entry : skill.getExpEntries()) {
				if(entry.getId() == id) {					
					expEntryRepository.deleteById(id);
				}
			}
		}
	}

	public ExpEntry getExpEntryById(long id) {
		Optional<ExpEntry> optionalExpEntry = expEntryRepository.findById(id);
		if(optionalExpEntry.isPresent()) {
			return optionalExpEntry.get();			
		}
		return null;
	}

}
