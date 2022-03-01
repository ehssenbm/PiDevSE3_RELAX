package pi.spring.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vote implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private int voteId ;
	private VoteType voteType ;
	@ManyToOne(fetch =FetchType.LAZY)
	private Post post;
	@ManyToOne(fetch =FetchType.LAZY)
	private User user;
	

}
