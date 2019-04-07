package com.peerconnect.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.peerconnect.login.UsertableService;
import com.peerconnect.request.Requesttable;
import com.peerconnect.request.RequesttableService;

@RestController
public class ChatmapController {
	@Autowired
	UsertableService userService;
	
	@Autowired
	RequesttableService requestService;
	
	@Autowired
	ChatmapRepository chatmapRepo;
	
	
	@GetMapping("/requestaccepted")
    public ModelAndView allrequestaccepted(Model model) {
    	int loggedid = userService.findLoggedId();
    	List<Requesttable> myRequestIds = requestService.getMyRequestIds(loggedid);
    	
    	
    	List<Integer> list = new ArrayList<>();;
    	
    	for (int i = 0 ; i < myRequestIds.size() ; i++) {
    		list.add(myRequestIds.get(i).getRequestid());
    	}

    	ModelAndView model3 = new ModelAndView("/requestaccepted");

    	model3.addObject("requestaccepted", chatmapRepo.findAllByRequestidIn(list));

        return model3;
    }
}
