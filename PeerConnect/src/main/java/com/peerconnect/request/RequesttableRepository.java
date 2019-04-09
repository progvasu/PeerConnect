package com.peerconnect.request;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequesttableRepository extends JpaRepository<Requesttable, Integer> {
	List<Requesttable> findAllByRequestby(int requestby);
	List<Requesttable> findAllByRequestidIn(List<Integer> requestids);
	Requesttable findByRequestid(int requestid);
	
}
