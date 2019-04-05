package com.peerconnect.chat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChattableRepository extends JpaRepository<Chattable, Integer> {
}