package com.peerconnect.members;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peerconnect.login.UsertableService;

@Service
public class MemberstableService {
	@Autowired 
	MemberstableRepository membersRepository;
	
	@Autowired 
	UsertableService userService;
	
	public boolean insertPairs(String groupId, String[] member_ids)	{
		// create a list of Memberstable objects
		List<Memberstable> rows = new ArrayList<>();
		
		for (String id : member_ids) {
			rows.add(new Memberstable(Integer.parseInt(groupId), Integer.parseInt(id), 'A'));
		}
	
		membersRepository.saveAll(rows);
		
		return true;
	}
	
	public List<Integer> getMyGroupIds()	{
		List<Integer> myGroupIds = new ArrayList<>();
		
		for (Memberstable obj : membersRepository.findByUserId(userService.findLoggedId())) {
			myGroupIds.add(obj.getGroupId());
		}
		
		return myGroupIds;
	}
}
