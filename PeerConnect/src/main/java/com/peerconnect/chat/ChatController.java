package com.peerconnect.chat;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.peerconnect.group.GroupstableService;
import com.peerconnect.login.UsertableService;
import com.peerconnect.request.RequesttableService;
import com.peerconnect.users.UsersSubtableService;

@RestController
public class ChatController {
	@Autowired
	private ChattableService chatService;
	@Autowired
	private UsertableService userService;
	@Autowired
	private ChatmapService chatMapService;
	@Autowired
	private GroupstableService groupService;
	@Autowired
	private UsersSubtableService usersubService;
	@Autowired
	private RequesttableService requestService;
	
	@RequestMapping("/chatinsert")
	public ModelAndView openChat(@RequestParam("requestid") String requestid, @RequestParam("groupid") String groupid, RedirectAttributes redirectAttr)	{
		// change it to post
		
		// database insertion
		// chattable
		Chattable obj = new Chattable();
		obj.setMessage("Hi! I have it");
		obj.setSenderid(userService.findLoggedId());
		obj.setChatid(Integer.parseInt(groupid+requestid+userService.findLoggedId()));
		chatService.createChatEntry(obj);
		
		// chatmap
		Chatmap obj2 = new Chatmap();
		obj2.setAcceptby(userService.findLoggedId());
		obj2.setChatid(obj.getChatid());
		obj2.setGroupid(Integer.parseInt(groupid));
		obj2.setRequestid(Integer.parseInt(requestid));
		chatMapService.createChatmapEntry(obj2);
		
		redirectAttr.addFlashAttribute("valid", true);
		redirectAttr.addFlashAttribute("chatid", obj.getChatid());
		
		return new ModelAndView("redirect:/chat/chat");
	}
	
	@RequestMapping("/chat/chat")
	public ModelAndView displayChat(Model model)	{
		// only allow valid requests
		if (model.asMap().get("valid") == null)
			return new ModelAndView("redirect:/home");
		boolean valid = (boolean) model.asMap().get("valid");
		if (valid == false || !valid) {
			return new ModelAndView("redirect:/home");
		}
		
		// add an object for old message
		
		ModelAndView model2 = new ModelAndView("chat/chat");
		
		// chat id for chat messaging
		model2.addObject("chatid", model.asMap().get("chatid"));
		int chatid = (Integer)model.asMap().get("chatid");
		// chat id for chat messaging
        model2.addObject("chatid", chatid);
        // get chatmap object
        Chatmap obj = chatMapService.getChatMapObject(chatid);
        // get groupname
        model2.addObject("groupname", groupService.getGroupName(obj.getGroupid()));
        // get request message
        model2.addObject("requestmsg", requestService.getRequestObject(obj.getRequestid()).get().getRequestmsg());
        // get acceptor name
        if (obj.getAcceptby() == userService.findLoggedId())	{
        	model2.addObject("acceptname", "YOU");
        	model2.addObject("requestorname", usersubService.getUserNameFromId(requestService.getRequestObject(obj.getRequestid()).get().getRequestby()));
        }
        else	{
        	model2.addObject("acceptname", usersubService.getUserNameFromId(obj.getAcceptby()));
        	model2.addObject("requestorname", "YOU");
        }
		
		return model2;
	}
	
    @RequestMapping(method=RequestMethod.POST, value="/chat/chat")
    public ModelAndView displayChat1(@RequestParam("chatid") int chatid) {
        ModelAndView model2 = new ModelAndView("chat/chat");
        
        // chat id for chat messaging
        model2.addObject("chatid", chatid);
        // get chatmap object
        Chatmap obj = chatMapService.getChatMapObject(chatid);
        // get groupname
        model2.addObject("groupname", groupService.getGroupName(obj.getGroupid()));
        // get request message
        model2.addObject("requestmsg", requestService.getRequestObject(obj.getRequestid()).get().getRequestmsg());
        // get acceptor name
        if (obj.getAcceptby() == userService.findLoggedId())	{
        	model2.addObject("acceptname", "YOU");
        	model2.addObject("requestorname", usersubService.getUserNameFromId(requestService.getRequestObject(obj.getRequestid()).get().getRequestby()));
        }
        else	{
        	model2.addObject("acceptname", usersubService.getUserNameFromId(obj.getAcceptby()));
        	model2.addObject("requestorname", "YOU");
        }
        	
        model2.addObject("valid", true);
        
        return model2;
    }

    // chat handler methods
	@MessageMapping("{chatid}/message2")
	@SendTo("/topic/{chatid}/message")
	public Chattable getMessage(Principal principle, @DestinationVariable String chatid, @Payload Chattable chatResponse) {
		chatResponse.setSenderid(userService.findLoggedId(principle.getName()));
		chatService.createChatEntry(chatResponse);
		return chatResponse;
	}
	
}
