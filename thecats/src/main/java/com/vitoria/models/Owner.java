package com.vitoria.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner implements Serializable{ 
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="owners_name")
	private String name;
	
	@Column(name="owners_age")
	private Integer age;
	
	@Column(name="owners_adress")
	private String adress;
	
	@Column(name="owners_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="owners_number_of_pets")
	private Integer numberOfPets;
	
	@Column(name="owners_cats")
	@OneToMany(mappedBy="owner", cascade= CascadeType.ALL)
	private Set<Cats> ownersCats;
	
	
	public Owner(String name, Integer age, String adress, Integer id, Integer numberOfPets, Set<Cats> ownersCats) {
		this.name = name;
		this.age = age;
		this.adress = adress;
		this.id = id;
		this.numberOfPets = numberOfPets;
		this.ownersCats = ownersCats;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumberOfPets() {
		return numberOfPets;
	}
	public void setNumberOfPets(Integer numberOfPets) {
		this.numberOfPets = numberOfPets;
	}
	public Set<Cats> getOwnersCats() {
		return ownersCats;
	}
	public void setOwnersCats(Set<Cats> ownersCats) {
		this.ownersCats = ownersCats;
	}
}
