 package com.peerconnect.group;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peerconnect.login.UsertableService;

@Service
public class GroupstableService {
	@Autowired
	private GroupstableRepository groupsRepository;
	
	@Autowired
	private UsertableService usertableService;
	
	public boolean createGroup(Groupstable group) {
		// create a new group
		// but also need to check whether this group was already created or not
		
		// 1. checking does the group already exist
		Groupstable ret_group = groupsRepository.findByName(group.getName());
		if (ret_group != null)	{
			return false;
		}
		
		// else 2. create the group			
		group.setAdmin_id(usertableService.findLoggedId());
		groupsRepository.save(group);
		groupsRepository.flush();
		
		return true;
	}
	
	public String getGroupId(String groupName)	{
		Groupstable ret_group = groupsRepository.findByName(groupName);
		return ret_group.getId() + "";
	}
	
	public String getGroupName(int groupId)	{
		Groupstable ret_group = groupsRepository.findById(groupId);
		return ret_group.getName();
	}
	
	public List<String> getGroupNames(List<Integer> groupIds)	{
		List<String> groupNames = new ArrayList<>();
		
		for (int id : groupIds) {
			groupNames.add(getGroupName(id));
		}
		
		return groupNames;
	}
	
	public Groupstable getGroupById(int groupid)	{
		return groupsRepository.findById(groupid);
	}
}
