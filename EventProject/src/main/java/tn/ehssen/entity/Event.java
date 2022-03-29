package tn.ehssen.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;







@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EnableScheduling
public class Event implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEvent; 
	@Column(length = 3000)
	private String nameEvent;
	
	private int nbPlace;
	@Column(length = 3000)
	private String EventDescription; 
	@Temporal(TemporalType.DATE)
	private Date dateEvent; 
	private String Adress;
	@Column(nullable = true, length = 64)
    private String photos;
	@Enumerated(EnumType.STRING)
	 CategorieEvents CategorieEvents;
	@Column(length = 20)
	    private String pseudo;
	
	 private long soireeId;
	
	
	@OneToOne(mappedBy = "Event")
    private UploadImagePublication image ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="EventCo")
	@JsonIgnore
	private Set<Comments> Comments;
	
	
	
	@ManyToMany(mappedBy = "Events", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JsonIgnore
	Set<User> User;
	
	@ManyToOne
	@JsonIgnore
	private Admin AdminEvent;
	
	
	@ManyToOne
	@JsonIgnore
	private User UserEvent;

	//@OneToMany(mappedBy="event")
   // private Set<Reservation> reservations;
	
}
