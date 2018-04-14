package com.medifeeds.register.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="user")
public class User {
	@Id
	private Long id;
	
	private String firstname;
	private String lastname;
	private String useremail;
	private String password;
	private String usertype;
	
	public User(Long id, String firstname, String lastname, String useremail, String password, String usertype) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.useremail = useremail;
		this.password = password;
		this.usertype = usertype;
	}
	public User(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
}
