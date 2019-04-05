package com.peerconnect.requestgroup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestgroupService {
	@Autowired
	RequestgroupRepository requestGroupRepository;
	
	public boolean insertPairs(int request_id, String[] selected_groups)	{
		// create a list of Memberstable objects
		List<Requestgrouptable> rows = new ArrayList<>();
		
		for (String id : selected_groups) {
			rows.add(new Requestgrouptable(request_id, Integer.parseInt(id)));
		}
	
		requestGroupRepository.saveAll(rows);
		
		return true;
	}
	
	public List<Integer> getGroupRequestIds(int groupid)	{
		List<Requestgrouptable> requestid_object = requestGroupRepository.findByGroupid(groupid);
		
		List<Integer> requestids = new ArrayList<>();
		
		for (Requestgrouptable obj : requestid_object) {
			requestids.add(obj.getRequestid());
		}
		
		return requestids;
	}
}
