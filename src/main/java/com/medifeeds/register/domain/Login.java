package com.medifeeds.register.domain;

public class Login {
	private String useremail;
	private String password;
	private String newpassword;
	
	public Login(String useremail,String password){
		this.useremail=useremail;
		this.password=password;
	}
	public Login(String useremail,String password,String newassword){
		this.useremail=useremail;
		this.password=password;
		this.newpassword=newassword;
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
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
}
