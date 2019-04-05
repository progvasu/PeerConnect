package com.peerconnect.chat;

import javax.persistence.*;

@Entity
@Table(name = "chatmap")
@IdClass(ChatmapKey.class)
public class Chatmap {
	@Id
	private int chatid;
	@Id
	private int groupid;
	@Id
	private int requestid;
	@Id
	private int acceptby;
	
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
}
