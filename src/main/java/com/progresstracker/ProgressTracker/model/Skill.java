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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SKILL_ID_GEN")
	@SequenceGenerator(name = "SKILL_ID_GEN", sequenceName = "skill_id_seq", allocationSize = 1, initialValue = 1)
	private long id;

	private String name;
	private LocalDate startDate;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ExpEntry> expEntries;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", startDate=" + startDate + ", expEntries=" + expEntries
				+ ", goals=" + goals + "]";
	}

	
}
