package com.vitoria.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="show")
public class Show implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="show_name", unique=true)
	private String name;
	
	@Column(name="show_genre")
	private String genre;
	
	@Column(name="show_synopsis")
	private String synopsis;
	
	@Column(name="show_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_profile_id")
	private UserProfile userProfile;

	public Show() {
	}

	public Show(String name, String genre, String synopsis, Integer id, UserProfile userProfile) {
		this.name = name;
		this.genre = genre;
		this.synopsis = synopsis;
		this.id = id;
		this.userProfile = userProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
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
