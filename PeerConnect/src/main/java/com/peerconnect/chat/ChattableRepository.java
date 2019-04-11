package com.peerconnect.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChattableRepository extends JpaRepository<Chattable, Integer> {
	List<Chattable> findAllByChatidOrderByDateAsc(int chatid);
}