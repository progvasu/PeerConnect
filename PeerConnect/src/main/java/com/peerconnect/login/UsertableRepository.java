package com.peerconnect.login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsertableRepository extends JpaRepository<Usertable, Integer> {
	Usertable findByUsername(String username);
}
