package com.peerconnect.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatmapService {
	@Autowired
	private ChatmapRepository chatmapRepository;
	
	public boolean createChatmapEntry(Chatmap chatmap)	{
		chatmapRepository.save(chatmap);
		
		return true;
	}
}
