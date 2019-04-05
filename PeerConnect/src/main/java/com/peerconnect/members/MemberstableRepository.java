package com.peerconnect.members;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberstableRepository extends JpaRepository<Memberstable, MembersKey>{
	List<Memberstable> findByUserId(int user_id);
}
