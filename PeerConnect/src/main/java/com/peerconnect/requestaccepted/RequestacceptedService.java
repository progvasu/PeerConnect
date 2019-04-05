package com.peerconnect.requestaccepted;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestacceptedService {

	@Autowired
	RequestacceptedRepository requestacceptedRepository;
	
	
	public List<Requestacceptedtable> getacceptedRequests(List<Integer> requestids)	{
		
//		List<Requestacceptedtable> list = new ArrayList<>();
//		for (int id : requestids) {
//			list.add(requestacceptedRepository.findAllByRequestid(id));
//		}
		return  requestacceptedRepository.findAllByRequestidIn(requestids);
		
	}
	
	
}
