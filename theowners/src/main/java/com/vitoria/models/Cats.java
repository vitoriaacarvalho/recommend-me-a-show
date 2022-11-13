package com.vitoria.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cats implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="cats_name")
	private String name;

	@Column(name="cats_color")
	private String color;

	@Column(name="cats_personality")
	private String personality;

	@Column(name="cats_Id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="cats_age")
	private Integer age;

	@ManyToOne
	@JoinColumn(name="cats_owner",nullable=false)
	private Owner owner;

	public Cats(String name, String color, String personality, Integer id, Integer age, Owner owner) {
		this.name = name;
		this.color = color;
		this.personality = personality;
		this.id = id;
		this.age = age;
		this.owner = owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}
