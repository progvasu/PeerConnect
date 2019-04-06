package com.peerconnect.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersSubtableRepository extends JpaRepository<UsersSubtable, String> {
	UsersSubtable findByUserid(int userid);
}
