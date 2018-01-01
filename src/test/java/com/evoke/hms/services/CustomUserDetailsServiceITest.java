package com.evoke.hms.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evoke.hms.HmsApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HmsApplication.class)
@WebAppConfiguration
public class CustomUserDetailsServiceITest {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Test
	public void loadUserByUsername(){
		String userName = "testuser"; 
		UserDetails  user = customUserDetailsService.loadUserByUsername(userName);
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getUsername(), "testuser");
	}

	
}
