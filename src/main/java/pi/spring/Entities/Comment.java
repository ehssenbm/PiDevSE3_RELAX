package pi.spring.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private int comId ;
	private String text;
	@Temporal (TemporalType.DATE)
	private Date comDate;
	@ManyToOne(fetch =FetchType.LAZY)
	private Post post;
	@ManyToOne(fetch =FetchType.LAZY)
	private User user;
}
