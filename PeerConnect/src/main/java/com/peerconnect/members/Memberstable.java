package com.peerconnect.members;

import javax.persistence.*;

@Entity
@Table(name = "usergroup")
@IdClass(MembersKey.class)
public class Memberstable {
	@Id
	@Column(name="userid")
	private int userId;
	@Id
	@Column(name="groupid")
	private int groupId;
	private char status;
	
	public Memberstable() {
	}

	public Memberstable(int groupId, int user_id, char status) {
		this.userId = user_id;
		this.groupId = groupId;
		this.status = status;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int user_id) {
		this.userId = user_id;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
}
