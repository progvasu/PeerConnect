package com.peerconnect.chat;

import java.util.ArrayList;
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
import com.peerconnect.requestgroup.RequestgroupService;

@RestController
public class ChatmapController {
	@Autowired
	UsertableService userService;
	
	@Autowired
	RequesttableService requestService;
	
	@Autowired
	ChatmapRepository chatmapRepo;
	
	@Autowired 
	private MemberstableService membersService; 
	
	@Autowired
	private GroupstableService groupService;
	
	@Autowired
	ChatmapService chatmapService;
	
	
	@GetMapping("/requestaccepted")
    public ModelAndView allrequestaccepted(Model model) {
    	int loggedid = userService.findLoggedId();
    	List<Requesttable> myRequestIds = requestService.getMyRequestIds(loggedid);
    	
    	
    	List<Integer> list = new ArrayList<>();
    	
    	for (int i = 0 ; i < myRequestIds.size() ; i++) {
    		list.add(myRequestIds.get(i).getRequestid());
    	}

    	ModelAndView model3 = new ModelAndView("/requestaccepted");

    	model3.addObject("requestaccepted", chatmapRepo.findAllByRequestidIn(list));

        return model3;
    }
	//-------------------------------------------------------------------------------
	@GetMapping("/requestacceptedbyme/accepted")
    public ModelAndView requestacceptedbyme(Model model) {
		
		List<Integer> myGroupIds = membersService.getMyGroupIds();
    	
		// showing each group's request
    	HashMap<Groupstable, List<Requesttable>> hmap2 = new HashMap<>();
    	for (int i : myGroupIds) {
    		//System.out.println(chatmapService.getRequestsAcceptedByMe(i).size());
    		hmap2.put(groupService.getGroupById(i), requestService.getRequestsAcceptedByMeObjects(chatmapService.getRequestsAcceptedByMe(i)));
    		//System.out.println(requestService.getRequestsAcceptedByMeObjects(chatmapService.getRequestsAcceptedByMe(i)).size());
    	}
    	//requestService.chatmapService.getRequestsAcceptedByMe(i)
    	//System.out.println(hmap2.size());
    	model.addAttribute("grouprequests", hmap2);
        return new ModelAndView("/requestacceptedbyme/accepted");
    }
	//-------------------------------------------------------------------------------

}
