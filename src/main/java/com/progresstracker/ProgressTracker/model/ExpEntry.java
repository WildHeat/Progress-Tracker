package com.progresstracker.ProgressTracker.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ExpEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPENTRY_ID_GEN")
	@SequenceGenerator(name = "EXPENTRY_ID_GEN", sequenceName = "expentry_id_seq", allocationSize = 1, initialValue = 1)
	private long id;
	
	private int exp;
	private LocalDate timeEntry;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public LocalDate getTimeEntry() {
		return timeEntry;
	}
	public void setTimeEntry(LocalDate timeEntry) {
		this.timeEntry = timeEntry;
	}
	
	

}
