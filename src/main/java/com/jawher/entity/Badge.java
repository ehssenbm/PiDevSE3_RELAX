package com.jawher.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="badge")
public class Badge implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_badge")
	private int id_badge;
	
 
 
	@Column(name="description")
	private String description;
	
	
	
	
	
	 
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id_badge;
	}

	public String getDescription() {
		return description;
	}

	
	 

	 

	 

	public void setDescription(String nom) {
		this.description = nom;
	}

	
	

	 

	public void setId(int id) {
		this.id_badge = id;
	}

	 

}
