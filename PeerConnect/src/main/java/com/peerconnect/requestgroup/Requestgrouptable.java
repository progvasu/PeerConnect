package com.peerconnect.requestgroup;

import javax.persistence.*;

@Entity
@Table(name = "requestgroup")
@IdClass(RequestgroupKey.class)
public class Requestgrouptable {
	@Id
	@Column(name="requestid")
	private int requestid;
	@Id
	@Column(name="groupid")
	private int groupid;
	
	public Requestgrouptable() {
	}

	public Requestgrouptable(int requestid, int groupid) {
		this.requestid = requestid;
		this.groupid = groupid;
	}
	
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}	
}
