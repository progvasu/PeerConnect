package com.peerconnect.home;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.peerconnect.login.UsertableController;

public class MockitoUsertableControllerTest {
	@InjectMocks
	private UsertableController usertableController = new UsertableController();
	
	@Mock
	private Model model;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void registrationTester()	{
		assertEquals(usertableController.registration(model), "registration");
	}
	
	@Test
	public void loginTester()	{
		assertEquals(usertableController.login(model, "error", "logout"), "login");
	}
}