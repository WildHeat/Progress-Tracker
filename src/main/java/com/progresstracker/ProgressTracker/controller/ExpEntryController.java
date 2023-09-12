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

import com.progresstracker.ProgressTracker.model.ExpEntry;
import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.service.ExpEntryService;

@RestController
@RequestMapping("/api/v1/expentries")
public class ExpEntryController {
	
	@Autowired
	private ExpEntryService expEntryService;

	@GetMapping()
	public ResponseEntity<List<ExpEntry>> getAllExpEntrys() {
		return ResponseEntity.ok(expEntryService.getAllExpEntrys());
	}

	@PutMapping()
	public ResponseEntity<ExpEntry> updateExpEntry(@AuthenticationPrincipal User user, @RequestBody ExpEntry expEntry) {
		return ResponseEntity.ok(expEntryService.updateExpEntry(expEntry));
	}
	
	@PostMapping()
	public ResponseEntity<ExpEntry> addExpEntry(@RequestBody ExpEntry expEntry){
		return ResponseEntity.ok(expEntryService.addExpEntry(expEntry));		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ExpEntry> deleteExpEntryById(@AuthenticationPrincipal User user, @PathVariable long id) {
		expEntryService.deleteById(id, user);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExpEntry> getExpEntryById(@PathVariable long id, @AuthenticationPrincipal User user){
		return ResponseEntity.status(HttpStatus.OK).body(expEntryService.getExpEntryById(id));
	}

}
