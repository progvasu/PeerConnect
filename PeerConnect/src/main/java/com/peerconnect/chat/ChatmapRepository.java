package com.peerconnect.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatmapRepository extends JpaRepository<Chatmap, ChatmapKey> {
	List<Chatmap> findByGroupidAndAcceptby(int groupid, int acceptby);
	List<Chatmap> findAllByRequestidIn(List<Integer> requestid);
	
	Chatmap findByChatid(int chatid);
}