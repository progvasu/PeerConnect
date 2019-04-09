package com.peerconnect.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.peerconnect.login.UsertableService;
import com.peerconnect.request.Requesttable;
import com.peerconnect.request.RequesttableService;
import com.peerconnect.users.UsersSubtableService;

@RestController
public class ChatmapController {
	@Autowired
	UsertableService userService;
	
	@Autowired
	UsersSubtableService usersSubtableService;
	
	@Autowired
	RequesttableService requestService;
	
	@Autowired
	ChatmapService chatmapService;
	
	@GetMapping("/requestaccepted")
    public ModelAndView allrequestaccepted(Model model) {
    	
    	List<Integer> myRequestIds = requestService.getMyRequestraisedIds();
    	HashMap<Requesttable, List<String>> hmap3 = new HashMap<>();
    	for (int i : myRequestIds) {
    		List<Integer> acceptersid = chatmapService.getChatMapObjectsbyrequestid(i);
    		List<String> acceptersname = new ArrayList<>();;
    		for(int temp : acceptersid)
    		{
    			acceptersname.add(usersSubtableService.getUserNameFromId(temp));
    		}
    		hmap3.put(requestService.getRequestObj(i), acceptersname);
    	}
    	
    	model.addAttribute("requestaccepted", hmap3);
        return new ModelAndView("/requestaccepted");
    	
    }
	
	
	
}
