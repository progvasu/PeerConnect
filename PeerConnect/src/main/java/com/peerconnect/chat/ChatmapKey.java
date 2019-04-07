package com.peerconnect.chat;

import java.io.Serializable;


public class ChatmapKey implements Serializable{
	private static final long serialVersionUID = 1L;

	private int chatid;
	private int groupid;
	private int requestid;
	private int acceptby;
	
	public ChatmapKey() {
	}
	
	public int getChatid() {
		return chatid;
	}

	public void setChatid(int chatid) {
		this.chatid = chatid;
	}

	public int getGroupid() {
		return groupid;
	}



	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}



	public int getRequestid() {
		return requestid;
	}



	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}



	public int getAcceptby() {
		return acceptby;
	}



	public void setAcceptby(int acceptby) {
		this.acceptby = acceptby;
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
