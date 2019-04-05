package com.peerconnect.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChattableService {
	@Autowired
	private ChattableRepository chattableRepository;
	
	public boolean createChatEntry(Chattable chat)	{
		chattableRepository.save(chat);
		
		return true;
	}
}
