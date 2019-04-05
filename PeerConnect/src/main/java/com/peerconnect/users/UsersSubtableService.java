package com.peerconnect.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersSubtableService {
	@Autowired
	private UsersSubtableRepository usersSubRepository;
	
	public List<UsersSubtable> getOtherUsersDetails()	{
		List<UsersSubtable> list;
		
		list = usersSubRepository.findAll();
		
		// not removing the current user yet
		
		return list;
	}
}
