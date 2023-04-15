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
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GEN")
	@SequenceGenerator(name = "USER_ID_GEN", sequenceName = "user_id_seq", allocationSize = 1, initialValue = 1)
	private long id;
	private String username;
	private LocalDate userJoinDate;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Skill> skills;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getUserJoinDate() {
		return userJoinDate;
	}
	public void setUserJoinDate(LocalDate userJoinDate) {
		this.userJoinDate = userJoinDate;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
