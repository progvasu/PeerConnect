package com.peerconnect.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peerconnect.login.UsertableService;

@Service
public class ChatmapService {
	@Autowired
	private ChatmapRepository chatmapRepository;
	
	@Autowired
	private UsertableService usertableService;
	
	public boolean createChatmapEntry(Chatmap chatmap)	{
		chatmapRepository.save(chatmap);
		
		return true;
	}
	
	List<Integer> getRequestsAcceptedByMe(int groupid)	{
		List<Chatmap> chatmaps = chatmapRepository.findByGroupidAndAcceptby(groupid, usertableService.findLoggedId()); 
		
		List<Integer> requestids = new ArrayList<>();
		
		for(Chatmap temp : chatmaps)
			requestids.add(temp.getRequestid());
		
		return requestids;
	}
	
	
	
	// get my requests which got accepted
	public List<Chatmap> getAcceptedRequests(List<Integer> requestids)	{
		return  chatmapRepository.findAllByRequestidIn(requestids);
	}
}
