package pi.spring.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private int postId ;
	@Temporal (TemporalType.DATE)
	private Date createDate;
	private String subject ;
	@Nullable
	private String title;
	@Lob
	private String description;
	private Integer voteCount;
	@ManyToOne
	User user;
}
