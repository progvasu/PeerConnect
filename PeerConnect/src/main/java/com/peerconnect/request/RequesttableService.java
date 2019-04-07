package com.peerconnect.request;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peerconnect.login.UsertableService;
import com.peerconnect.requestgroup.RequestgroupService;
import com.peerconnect.users.UsersSubtableService;

@Service
public class RequesttableService {
	@Autowired
	private RequesttableRepository requestRepository;

	@Autowired
	private UsertableService userService;
	
	@Autowired
	private RequestgroupService requestGroupService;
	
	@Autowired
	private UsersSubtableService subtableService;
	
	public RequesttableService() {
	}

	public int createRequest(String request_msg) {
		Requesttable request = new Requesttable(request_msg);
		
		request.setRequestby(userService.findLoggedId());
		requestRepository.save(request);
		requestRepository.flush();
		
		return request.getRequestid();
	}
	
	public List<Requesttable> getGroupRequests(int groupid)	{
		// find all the requests associated with this group
		List<Requesttable> ret = requestRepository.findAllById(requestGroupService.getGroupRequestIds(groupid));
		
		// find all the request ids accepted by for this group
//		List<Integer> myacceptedrequestids = 
		
		Iterator<Requesttable> iter = ret.iterator();
		while(iter.hasNext())	{
			Requesttable temp = iter.next();
			temp.setRequestbyname(subtableService.getUserNameFromId(temp.getRequestby()));
		}
				
		return ret;
	}
	
	public List<Requesttable> getMyRequestIds(int loggedid)    {
        return requestRepository.findAllByRequestby(loggedid);
	}
}