package com.peerconnect.chat;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.peerconnect.group.Groupstable;
import com.peerconnect.group.GroupstableService;
import com.peerconnect.login.UsertableService;
import com.peerconnect.members.MemberstableService;
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
	
	@Autowired 
	private MemberstableService membersService; 
	
	@Autowired
	private GroupstableService groupService;
	
	@GetMapping("/myrequests")
    public ModelAndView allrequestaccepted(Model model) {
    	List<Requesttable> myRequestObjs = requestService.getMyRaisedRequestObjects();
    	
    	for (Requesttable temp : myRequestObjs) {
    		for (Chatmap chatmapobj : temp.getChatmaps()) {
				chatmapobj.setGroupname(groupService.getGroupName(chatmapobj.getGroupid()));
				chatmapobj.setAcceptorname(usersSubtableService.getUserNameFromId(chatmapobj.getAcceptby()));
			}
    	}
    	
    	model.addAttribute("myrequests", myRequestObjs);
    	
        return new ModelAndView("/myrequests/myrequests");
    }
	
	@GetMapping("/requestacceptedbyme/accepted")
    public ModelAndView requestacceptedbyme(Model model) {
		List<Integer> myGroupIds = membersService.getMyGroupIds();
    	
		// showing each group's request
    	HashMap<Groupstable, List<Requesttable>> hmap2 = new HashMap<>();
    	for (int i : myGroupIds) {
    		hmap2.put(groupService.getGroupById(i), requestService.getRequestsAcceptedByMeObjects(chatmapService.getRequestsAcceptedByMe(i)));
    	}
    	
    	model.addAttribute("grouprequests", hmap2);
        return new ModelAndView("/requestacceptedbyme/accepted");
    }
}
