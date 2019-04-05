package com.peerconnect.requestgroup;

import java.io.Serializable;

public class RequestgroupKey implements Serializable	{
	private static final long serialVersionUID = 1L;
	
	private int requestid;
	private int groupid;
	
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

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
