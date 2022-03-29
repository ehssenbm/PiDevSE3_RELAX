package com.jawher.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="quiz")
public class Quiz implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_quiz")
	private int id_quiz;
	
	@Column(name="Type")
	private String Type;
	
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Question> question;
	
	 public List<Question> getQuestion() {
	 		
	 		
	 		return question;
	 	}
	

	/*/ @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name = "id_quiz", referencedColumnName="id")
	    private List<Question> question=new ArrayList<>();*/
	 
	 
	 
	 
	 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id_quiz;
	}

	public String getType() {
		return Type;
	}

	 

	public void setId(int id) {
		this.id_quiz = id;
	}

	public void setType(String Type) {
		this.Type = Type;
	}

	
	
	
	 
	
	
	
	
	
		 

}
