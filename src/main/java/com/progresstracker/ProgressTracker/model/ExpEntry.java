package com.progresstracker.ProgressTracker.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class ExpEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPENTRY_ID_GEN")
	@SequenceGenerator(name = "EXPENTRY_ID_GEN", sequenceName = "expentry_id_seq", allocationSize = 1, initialValue = 1)
	private long id;
	@Min(0)
	private double hours;	
	@Min(1)
	@Max(5)
	private int focus;
	private LocalDate timeEntry;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getTimeEntry() {
		return timeEntry;
	}

	public void setTimeEntry(LocalDate timeEntry) {
		this.timeEntry = timeEntry;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public int getFocus() {
		return focus;
	}

	public void setFocus(int focus) {
		this.focus = focus;
	}

	@Override
	public String toString() {
		return "ExpEntry [id=" + id + ", hours=" + hours + ", focus=" + focus + ", timeEntry=" + timeEntry + "]";
	}

}
