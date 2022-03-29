package tn.ehssen.entity;


import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;








@Entity
@Table( name = "users",
uniqueConstraints = {
@UniqueConstraint(columnNames = "username"),
@UniqueConstraint(columnNames = "email")
})
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idUser;

@NotBlank
@Size(max = 20)
private String username;

@NotBlank
@Size(max = 50)
@Email
private String email;

@NotBlank
@Size(max = 120)
private String password;

private int nbr_points;

@NotBlank
@Size(max = 120)
private String bureau_dept;


@OneToMany(cascade = CascadeType.ALL, mappedBy="User")
private Set<Comments> Commentss;

@ManyToMany
private Set<Event> Events;

@OneToMany(cascade = CascadeType.ALL, mappedBy="UserEvent")
private Set<Event> Event;




public Set<Comments> getCommentss() {
	return Commentss;
}



public void setCommentss(Set<Comments> commentss) {
	Commentss = commentss;
}



public Set<Event> getEvents() {
	return Events;
}



public void setEvents(Set<Event> events) {
	Events = events;
}

/*@ManyToMany(fetch = FetchType.LAZY)
@JoinTable( name = "user_roles",
joinColumns = @JoinColumn(name = "user_id"),
inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles = new HashSet<>();*/







public User() {
}



public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
@NotBlank @Size(max = 120) String password) {
super();
this.username = username;
this.email = email;
this.password = password;

}


public int getNbr_points() {
return nbr_points;
}

public void setNbr_points(int nbr_points) {
this.nbr_points = nbr_points;
}

public String getBureau_dept() {
return bureau_dept;
}

public void setBureau_dept(String bureau_dept) {
this.bureau_dept = bureau_dept;
}



public Long getIdUser() {
return idUser;
}

public void setIdUser(Long idUser) {
this.idUser = idUser;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

/*public Set<Role> getRoles() {
return roles;
}

public void setRoles(Set<Role> roles) {
this.roles = roles;
}*/
}