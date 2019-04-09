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
	
	public List<Integer> getRequestsAcceptedByMe(int groupid)	{
		List<Chatmap> chatmaps = chatmapRepository.findByGroupidAndAcceptby(groupid, usertableService.findLoggedId()); 
		
		List<Integer> requestids = new ArrayList<>();
	
		for(Chatmap temp : chatmaps)	{
			requestids.add(temp.getRequestid());
		}
		return requestids;
	}
	
	// get chatmap objects
//	public List<Chatmap> getChatMapObjects(List<Integer> requestids)	{
//		return  chatmapRepository.findAllByRequestidIn(requestids);
//	}
	public List<Integer> getChatMapObjectsbyrequestid(int requestid)	{
		List<Chatmap> chatmaps =chatmapRepository.findAllByRequestid(requestid);
		List<Integer> acceptersid = new ArrayList<>();
		
		for(Chatmap temp : chatmaps)	{
			acceptersid.add(temp.getAcceptby());
		}
		return acceptersid;
		
	}
	
	public Chatmap getChatMapObject(int chatid)	{
		return chatmapRepository.findByChatid(chatid);
	}
}
