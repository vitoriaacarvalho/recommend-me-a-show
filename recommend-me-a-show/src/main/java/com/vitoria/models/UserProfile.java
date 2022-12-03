package com.vitoria.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_profile")
public class UserProfile implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_profile_id")
	private Integer id;
	
	@Column(name="user_profile_type")
	private String type;
	
	@OneToOne(mappedBy="userProfile")
	private User user;
	
	@OneToMany(mappedBy="userProfile")
	private List<Show> show;

	public UserProfile() {
		super();
	}

	public UserProfile(Integer id, String type, User user, List<Show> show) {
		super();
		this.id = id;
		this.type = type;
		this.user = user;
		this.show = show;
	}

	public Integer getId() {
		return id;
	}

	public void ListId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void ListType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void ListUser(User user) {
		this.user = user;
	}

	public List<Show> getshow() {
		return show;
	}

	public void ListShow(List<Show> show) {
		this.show= show;
	}
}
