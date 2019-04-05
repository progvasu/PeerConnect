package com.peerconnect.group;

import java.io.Serializable;

public class GroupstableKey implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	
	public GroupstableKey() {
	}
	
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
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
