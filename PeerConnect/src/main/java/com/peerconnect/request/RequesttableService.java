package com.peerconnect.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peerconnect.login.UsertableService;
import com.peerconnect.requestgroup.RequestgroupService;

@Service
public class RequesttableService {
	@Autowired
	private RequesttableRepository requestRepository;

	@Autowired
	private UsertableService userService;
	
	@Autowired
	private RequestgroupService requestGroupService;
	
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
		return requestRepository.findAllById(requestGroupService.getGroupRequestIds(groupid));
	}
	
	public List<Requesttable> getMyRequestIds(int loggedid)    {
        return requestRepository.findAllByRequestby(loggedid);
	}
}