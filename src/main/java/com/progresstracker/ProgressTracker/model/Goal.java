package com.progresstracker.ProgressTracker.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Goal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOAL_ID_GEN")
	@SequenceGenerator(name = "GOAL_ID_GEN", sequenceName = "goal_id_seq", allocationSize = 1, initialValue = 1)
	private long id;
	private String goal;
	private boolean isComplete;
	private LocalDate deadLine;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDate getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(LocalDate deadLine) {
		this.deadLine = deadLine;
	}
	
}
