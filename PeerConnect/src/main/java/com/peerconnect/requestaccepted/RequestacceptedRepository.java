package com.peerconnect.requestaccepted;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RequestacceptedRepository extends JpaRepository<Requestacceptedtable , RequestacceptedtableKey>{
	List<Requestacceptedtable> findAllByRequestidIn(List<Integer> requestid);
}
