package com.peerconnect.users;

import javax.persistence.*;

@Entity
@Table(name = "usertable")
public class UsersSubtable {
	private int user_id;
	@Id
	private String username;
	
	private String name;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
