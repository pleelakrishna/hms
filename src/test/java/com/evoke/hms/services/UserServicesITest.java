package com.evoke.hms.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evoke.hms.HmsApplication;
import com.evoke.hms.business.IHMSUserBusinessModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HmsApplication.class)
@WebAppConfiguration
public class UserServicesITest {
	
	@Autowired
	IUserService iUserServices;
	
	@Test
	public void findByUsername() throws Exception{
		String userName = "testuser"; 
		IHMSUserBusinessModel hmsUser = iUserServices.findByUsername(userName);
		Assert.assertNotNull(hmsUser);
		Assert.assertEquals(hmsUser.getCreatedBy(), "ramu");
	}
	
}
