package tn.ehssen.entity;


import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.scheduling.annotation.EnableScheduling;

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
	private int idEvent; 
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
	

	//@OneToMany(mappedBy="event")
   // private Set<Reservation> reservations;
	
}
