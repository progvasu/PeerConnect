package com.peerconnect.chat;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChattableService {
	@Autowired
	private ChattableRepository chattableRepository;
	
	public boolean createChatEntry(Chattable chat)	{
		// set current date and time
		Calendar cal = Calendar.getInstance();
		cal.setTime(Calendar.getInstance().getTime());
		cal.add(Calendar.MINUTE, 330);
	   
        chat.setDate(cal.getTime());
        
		chattableRepository.save(chat);
		
		return true;
	}
	
	public List<Chattable> getChatMessages(int chatid)	{
		return chattableRepository.findAllByChatidOrderByDateAsc(chatid);
	}
}
