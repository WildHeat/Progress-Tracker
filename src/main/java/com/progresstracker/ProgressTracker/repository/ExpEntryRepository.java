package com.progresstracker.ProgressTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progresstracker.ProgressTracker.model.ExpEntry;

public interface ExpEntryRepository extends JpaRepository<ExpEntry, Long>{

}
