package tn.ehssen.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	public class EventOpenData implements Serializable{
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	    private long idEventO;
	    private String pricing_info;
	    @Temporal(TemporalType.DATE)
	    private Date dateEventOpenData;
	    
	    private String adress;
	    private int nbPlace;
		@Column(length = 3000)
		private String EventDescription; 
	    @Enumerated(EnumType.STRING)
		 CategorieEvents CategorieEvents;
	   
	    
	    @ElementCollection
	    private Collection<Long> soireeIds;
	    
	    public Collection<Long> getSoireeIds() {
	        return soireeIds;
	    }
	    public void setSoireeIds(Collection<Long> soireeIds) {
	        this.soireeIds = soireeIds;
	    }



	 

	   
}
