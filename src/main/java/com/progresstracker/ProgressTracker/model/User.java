package com.progresstracker.ProgressTracker.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {

	private static final long serialVersionUID = 6993802429779139108L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GEN")
	@SequenceGenerator(name = "USER_ID_GEN", sequenceName = "user_id_seq", allocationSize = 1, initialValue = 10)
	private long id;
	@NotBlank(message = "Username is mandatory")
	private String username;
	@NotBlank(message = "Passwor is mandatory")
	private String password;
	private LocalDate userJoinDate;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Skill> skills;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Authority authority;

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

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles = new ArrayList<>(Arrays.asList(new Authority("ROLE_USER")));
		return roles;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userJoinDate=" + userJoinDate
				+ ", skills=" + skills + ", authority=" + authority + "]";
	}

}
