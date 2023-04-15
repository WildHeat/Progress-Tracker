package com.progresstracker.ProgressTracker.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SKILL_ID_GEN")
	@SequenceGenerator(name = "SKILL_ID_GEN", sequenceName = "skill_id_seq", allocationSize = 1, initialValue = 1)
	private long id;
	
	private String name;
	private int exp;
	private LocalDate startDate;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<ExpEntry> expEntries;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Goal> goals;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public List<ExpEntry> getExpEntries() {
		return expEntries;
	}

	public void setExpEntries(List<ExpEntry> expEntries) {
		this.expEntries = expEntries;
	}

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

}
