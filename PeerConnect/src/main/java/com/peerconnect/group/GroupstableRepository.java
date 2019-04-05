package com.peerconnect.group;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupstableRepository extends JpaRepository<Groupstable, GroupstableKey> {
	Groupstable findByName(String groupName);
	Groupstable findById(int groupId);
}
