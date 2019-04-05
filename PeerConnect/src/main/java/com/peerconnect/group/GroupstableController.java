package com.peerconnect.group;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.peerconnect.login.UsertableService;
import com.peerconnect.members.MemberstableService;
import com.peerconnect.users.UsersSubtableService;

@RestController
public class GroupstableController {
	@Autowired
	private GroupstableService groupService;
	
	@Autowired
	private UsersSubtableService usersSubService;
	
	@Autowired
	private MemberstableService membersService;
	
	@Autowired
	private UsertableService userService;
	
	@RequestMapping("/groups/create")
	public ModelAndView createGroup()	{
		ModelAndView model = new ModelAndView("groups/create");
		
		return model;
	}
	
	@RequestMapping("/groups/insertMembers")
	public ModelAndView insertMembers()	{
		// redirect direct access to here
		ModelAndView model = new ModelAndView("groups/insertMembers");
		
		model.addObject("logged_id", userService.findLoggedId());
		model.addObject("candidate_members", usersSubService.getOtherUsersDetails());
		
		return model;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/groups/create")
	public ModelAndView createGroup(@ModelAttribute("group") Groupstable group, RedirectAttributes redirectAttr)	{
		if (groupService.createGroup(group))	{
			redirectAttr.addFlashAttribute("message", "Group Created Successfully");
			redirectAttr.addFlashAttribute("group_id", groupService.getGroupId(group.getName()));
			return new ModelAndView("redirect:/groups/insertMembers");
		}
		else	{
			// redirect to same page if group creation fails
			redirectAttr.addFlashAttribute("message", "Group Already Exists");
			return new ModelAndView("redirect:/groups/create");
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/groups/insertMembers")
	public ModelAndView insertMembers(HttpServletRequest request, RedirectAttributes redirectAttr)	{
		String message;
		
		// getting form values
		// getting group_id
		String group_id = request.getParameter("group_id");
		// getting member_ids
		String[] member_ids = request.getParameterValues("member_ids");
		
		if (membersService.insertPairs(group_id, member_ids))
			message = "Members Added Successfully";
		else
			message = "Some error";
	
		redirectAttr.addFlashAttribute("message", message);
		
		return new ModelAndView("redirect:/home");
	}
	
} 
