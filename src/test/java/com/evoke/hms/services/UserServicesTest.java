package com.evoke.hms.services;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.evoke.hms.business.IHMSUserBusinessModel;
import com.evoke.hms.dao.IUsersDAO;
import com.evoke.hms.model.HMSUser;


@RunWith(MockitoJUnitRunner.class)
public class UserServicesTest {
	
	private UserServiceImpl userServiceImpl;
	
	 @Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Mock
	private IUsersDAO usersDAO; 
	
	@Before
	public void setUp() throws Exception{
		userServiceImpl = new UserServiceImpl();
		userServiceImpl.setUsersDAO(usersDAO);
	}
	
	@Test
	public void testFindByUsername() throws Exception{
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("User Name Must not be Blank");
		String userName = null;
		IHMSUserBusinessModel hmsUser = userServiceImpl.findByUsername(userName);	
		Assert.assertNotNull(hmsUser);
	}
	
	@Test
	public void testFindByUsername_InvalidUser() throws Exception{
		thrown.expect(UsernameNotFoundException.class);
		thrown.expectMessage("No such user");
		String userName = "RAMU";
		Mockito.when(usersDAO.findByUsername(userName)).thenReturn(null);
		IHMSUserBusinessModel result = userServiceImpl.findByUsername(userName);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void testFindByUsername_ValidUser() throws Exception{
		String userName = "RAMU";
		HMSUser hmsUsers = new HMSUser();
		hmsUsers.setCreatedBy("RAMU");
		Mockito.when(usersDAO.findByUsername(userName)).thenReturn(hmsUsers);
		IHMSUserBusinessModel result = userServiceImpl.findByUsername(userName);
		Assert.assertEquals(result, hmsUsers);
		Assert.assertEquals(result.getCreatedBy(), "RAMU");
		Mockito.verify(usersDAO).findByUsername(userName);

	}
	

}
