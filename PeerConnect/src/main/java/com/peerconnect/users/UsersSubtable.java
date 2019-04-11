package com.peerconnect.users;

import javax.persistence.*;

@Entity
@Table(name = "usertable")
public class UsersSubtable {
	private int userid;
	@Id
	private String username;
	
	private String name;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
