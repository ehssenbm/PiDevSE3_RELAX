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
@Table(name="Evaluation")
public class Evaluation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_evaluation")
	private int id_evaluation;
	
	
	
	@Column(name="Opinioncollegue")
	private String Opinioncollegue;
	@Column(name="Score")
	private int Score;
	
	@Column(name="promotion")
	private String promotion;
	@Column(name="classement")
	private int classement;

	@Column(name="vote")
	private String vote;
	 
	
	/*/@OneToMany(mappedBy = "badge", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Badge> badge;*/


    @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "id_emp", insertable = true, updatable = true)
		@Fetch(FetchMode.JOIN)
		 
	    private Employer employer;
		
public Employer getEmployer() {
		
		
		return employer;
	}
	 
	
/*/public List<Badge> getBadge() {
		
		
		return badge;
}*/






	






	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	
	
	public int getId() {
		return id_evaluation;
	}

	 

	 

	public void setId(int id) {
		this.id_evaluation = id;
	}






	 






	 
 
 





public String getOpinioncollegue() {
	return Opinioncollegue;
}






public void setOpinioncollegue(String opinioncollegue) {
	Opinioncollegue = opinioncollegue;
}






public int getScore() {
	return Score;
}






public void setScore(int score) {
	Score = score;
}






public String getPromotion() {
	return promotion;
}






public void setPromotion(String promotion) {
	this.promotion = promotion;
}






public int getClassement() {
	return classement;
}






public void setClassement(int classement) {
	this.classement = classement;
}






public String getVote() {
	return vote;
}






public void setVote(String vote) {
	this.vote = vote;
}
 
}
