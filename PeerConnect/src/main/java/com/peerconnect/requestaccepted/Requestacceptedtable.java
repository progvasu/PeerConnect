package com.peerconnect.requestaccepted;

import javax.persistence.*;




@Entity
@Table(name = "chatmap")
@IdClass(RequestacceptedtableKey.class)
public class Requestacceptedtable {
	
	@Id
	private int chatid;
	@Id
	private int acceptby;
	@Id
	private int requestid;
	@Id
	private int groupid;
	
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
	
}
