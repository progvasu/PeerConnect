package com.peerconnect.login;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.peerconnect.group.Groupstable;
import com.peerconnect.group.GroupstableService;
import com.peerconnect.members.MemberstableService;
import com.peerconnect.request.Requesttable;
import com.peerconnect.request.RequesttableService;
import com.peerconnect.requestgroup.RequestgroupService;

@Controller
public class UsertableController {
	@Autowired
	UsertableService userService;
	
	@Autowired
    private SecurityService securityService;
	
	@Autowired
	private GroupstableService groupService;
	
	@Autowired 
	private MemberstableService membersService;
	
	@Autowired
	private RequesttableService requestService;
	
	@Autowired
	private RequestgroupService requestGroupService;
	
	@GetMapping("/registration")
    public String registration(Model model) {
		model.addAttribute("userForm", new Usertable());
		
		return "registration";
    }

	@RequestMapping(method=RequestMethod.POST, value="/registration")
    public String registration(@ModelAttribute("userForm") Usertable userForm) {
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }
    
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username or password is invalid!");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully!");

        return "login";
    }

    @GetMapping({"/", "/home"})
    public String welcome(Model model) {
    	model.addAttribute("message2", "LOGGED IN");
    	
    	List<Integer> myGroupIds = membersService.getMyGroupIds();
    	List<String> myGroupNames = groupService.getGroupNames(myGroupIds);
    	
    	HashMap<Integer, String> hmap = new HashMap<Integer, String>();
    	
    	for (int i = 0 ; i < myGroupIds.size() ; i++) {
    		hmap.put(myGroupIds.get(i), myGroupNames.get(i));
    	}
    
    	model.addAttribute("my_groups", hmap);
    	
    	// showing request
    	HashMap<Groupstable, List<Requesttable>> hmap2 = new HashMap<>();
    	
    	for (int i : myGroupIds) {
    		hmap2.put(groupService.getGroupById(i), requestService.getGroupRequests(i));
    	}
    	
    	model.addAttribute("groups_requests", hmap2);
    	
    	model.addAttribute("myid", userService.findLoggedId());
    	
        return "home";
    }
    
    // create request
    @RequestMapping(method=RequestMethod.POST, value="/home")
	public ModelAndView createRequest(HttpServletRequest request, RedirectAttributes redirectAttr)	{
		// insert into request table 
    	int request_id = requestService.createRequest(request.getParameter("request_msg"));
    	
    	// insert into request group table
    	String[] selected_groups = request.getParameterValues("selected_groups");
    	
    	requestGroupService.insertPairs(request_id, selected_groups);
    	
    	redirectAttr.addFlashAttribute("message", "Request Created");
		
		return new ModelAndView("redirect:/home");
	}
}
