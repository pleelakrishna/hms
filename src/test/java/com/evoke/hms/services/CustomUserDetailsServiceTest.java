package com.evoke.hms.services;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;

import com.evoke.hms.business.HMSAppGroupRolesBusinesModel;
import com.evoke.hms.business.HMSUserBusinessModel;
import com.evoke.hms.business.IHMSUserBusinessModel;

@RunWith(MockitoJUnitRunner.class)
public class CustomUserDetailsServiceTest {
	
	private CustomUserDetailsService customUserDetailsService;
	private HMSAppGroupRolesBusinesModel hmsAppGroupRoles;
	
	@Mock
	private IUserService iUserServices; 
	@Mock
	UserDetails userDetails;
	
	
	
	@Before
	public void setUp() throws Exception{
		customUserDetailsService = new CustomUserDetailsService();
		customUserDetailsService.setIUserServices(iUserServices);
		hmsAppGroupRoles = new HMSAppGroupRolesBusinesModel();
		hmsAppGroupRoles.setAppRolesName("ADMIN");
		
	}
	
	@Test
	public void testLoadUserByUsername() throws Exception{
		Set<HMSAppGroupRolesBusinesModel> appGroupRoles = new HashSet<HMSAppGroupRolesBusinesModel>();
		appGroupRoles.add(hmsAppGroupRoles);
		String userName = "RAMU";
		IHMSUserBusinessModel hmsUser = new HMSUserBusinessModel();
		hmsUser.setUserLoginId("testLoginId");
		hmsUser.setUserPassword("password");
		hmsUser.setAppGroupRoles(appGroupRoles);
		Mockito.when(iUserServices.findByUsername(userName)).thenReturn(hmsUser);
		UserDetails iUser = customUserDetailsService.loadUserByUsername(userName);
		Assert.assertNotNull(iUser);
		Assert.assertEquals(iUser.getPassword(), "password");
		
	}
	

}
