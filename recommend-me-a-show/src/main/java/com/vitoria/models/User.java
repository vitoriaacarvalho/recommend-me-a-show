package com.vitoria.models;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="table_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_email", unique=true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="profile_id")
	private UserProfile userProfile;
	
	
	public User() {
	}

	public User(String name, String email, String password, Integer id, UserProfile userProfile) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.id = id;
		this.userProfile=userProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
}
