package com.peerconnect.chat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatmapRepository extends JpaRepository<Chatmap, ChatmapKey> {
}