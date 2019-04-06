package com.peerconnect.login;

import javax.persistence.*;

@Entity
@Table(name = "usertable")
public class Usertable {
	
	private int userid;
	@Id
	private String username;
	
	private String password;
	private String name;
	private int phonenumber;
	
	@Transient
    private String passwordConfirm;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String user_email) {
		this.username = user_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPasswordConfirm() {
        return passwordConfirm;
    }
	public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
