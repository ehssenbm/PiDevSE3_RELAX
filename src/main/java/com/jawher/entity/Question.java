package com.jawher.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="question")
public class Question implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_question")
	private int id_question;
	
	@Column(name="description")
	private String description;

	
	 @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_quiz", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	 
    private Quiz quiz;
	
	
	    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonIgnore
	    private List<Choix> choix;
	
	
	
	
public Quiz getQuiz() {
		
		
		return quiz;
	}
	 
	
	
	 



	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	
	
	public int getId() {
		return id_question;
	}

	public String getDescription() {
		return description;
	}

	 

	public void setId(int id) {
		this.id_question = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

 
 

 
}
