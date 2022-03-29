package tn.ehssen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Base64;

@Entity
@Table (name="uploadImageEvents")
public class UploadImagePublication {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name = "id_image")
	private long id_image;
	
	private String name;
	@JsonIgnore
	@Lob
	private byte[] data;
	
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEvent", referencedColumnName = "idEvent")
    private Event Event;
    
	
	@Transient
	private String dataValue;
	
	public long getIdImage() {
		return id_image;
	}
	public void setIdImage(long id_image) {
		this.id_image = id_image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getDataValue() {
		return Base64.getEncoder().encodeToString(this.data);
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}


	public Event getEvent() {
		return Event;
	}

	public void setEvent(Event Event) {
		this.Event = Event;
	}
}