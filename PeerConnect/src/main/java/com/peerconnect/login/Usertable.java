package com.peerconnect.login;

import javax.persistence.*;

@Entity
@Table(name = "usertable")
public class Usertable {
	
	private int user_id;
	@Id
	private String username;
	
	private String password;
	private String name;
	private int phone_number;
	
	@Transient
    private String passwordConfirm;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public String getPasswordConfirm() {
        return passwordConfirm;
    }
	public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
