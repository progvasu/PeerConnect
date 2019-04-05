package com.peerconnect.requestgroup;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestgroupRepository extends JpaRepository<Requestgrouptable, RequestgroupKey>{
	List<Requestgrouptable> findByGroupid(int groupid);
}
