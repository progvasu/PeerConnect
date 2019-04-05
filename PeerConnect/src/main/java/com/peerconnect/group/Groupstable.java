package com.peerconnect.group;

import javax.persistence.*;


@Entity
@Table(name = "groupstable")
@IdClass(GroupstableKey.class)
public class Groupstable {
	@Id
	private int id;
	@Id
	private String name;
	private String description;
	private int admin_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
}
