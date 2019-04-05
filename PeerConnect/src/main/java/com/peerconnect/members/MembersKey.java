package com.peerconnect.members;

import java.io.Serializable;

public class MembersKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private int groupId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
