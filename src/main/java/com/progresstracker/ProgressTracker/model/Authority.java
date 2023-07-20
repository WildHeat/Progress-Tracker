package com.progresstracker.ProgressTracker.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority implements GrantedAuthority {
	private static final long serialVersionUID = -8483033137580728230L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHORITY_ID_GEN")
	@SequenceGenerator(name = "AUTHORITY_ID_GEN", sequenceName = "authority_id_seq", allocationSize = 1, initialValue = 1)
	private long id;
	private String authority;

	public Authority() {
	}

	public Authority(String authority) {
		this.authority = authority;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", authority=" + authority + "]";
	}

}
