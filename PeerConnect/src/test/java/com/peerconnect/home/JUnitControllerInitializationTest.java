package com.peerconnect.home;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import com.peerconnect.chat.ChatController;
import com.peerconnect.chat.ChatmapController;
import com.peerconnect.group.GroupstableController;
import com.peerconnect.login.UsertableController;;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JUnitControllerInitializationTest {
	@Autowired
	UsertableController usertableController;
	
	@Test
	public void testUsertableControllerInitialization()	{
		assertThat(usertableController).isNotNull();
	}
	
	@Autowired
	GroupstableController groupstableController;
	
	@Test
	public void testGroupstableControllerInitialization()	{
		assertThat(groupstableController).isNotNull();
	}
	
	@Autowired
	ChatController chatController;
	
	@Test
	public void testchatControllerInitialization()	{
		assertThat(chatController).isNotNull();
	}
	
	@Autowired
	ChatmapController chatmapController;
	
	@Test
	public void testChatmapControllerInitialization()	{
		assertThat(chatmapController).isNotNull();
	}
}
