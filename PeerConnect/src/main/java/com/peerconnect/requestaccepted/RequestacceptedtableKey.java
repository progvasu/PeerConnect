package com.peerconnect.requestaccepted;

import java.io.Serializable;

public class RequestacceptedtableKey implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int chatid;
	private int acceptby;
	private int requestid;
	private int groupid;
	
	public RequestacceptedtableKey() {
	}

	public int getChatid() {
		return chatid;
	}

	public void setChatid(int chatid) {
		this.chatid = chatid;
	}

	public int getAcceptby() {
		return acceptby;
	}

	public void setAcceptby(int acceptby) {
		this.acceptby = acceptby;
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

	
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
