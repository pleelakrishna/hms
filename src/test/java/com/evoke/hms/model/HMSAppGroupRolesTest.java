package com.evoke.hms.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class HMSAppGroupRolesTest {

	private HMSAppGroupRoles hmsAppGroupRoles;

	@Before
	public void setup(){
		hmsAppGroupRoles = new HMSAppGroupRoles();
	}
	
	@Test
	public void testGetAppRoleId() {
		ReflectionTestUtils.setField(hmsAppGroupRoles, "AppRoleId",101);
		Assert.assertEquals(hmsAppGroupRoles.getAppRoleId(), 101);
	}
	
	@Test
	public void testSetAppRoleId() {
		hmsAppGroupRoles.setAppRoleId(101);
		Assert.assertEquals(ReflectionTestUtils.getField(hmsAppGroupRoles, "AppRoleId"), 101);
	}
	
	@Test
	public void testGetAppRolesName() {
		ReflectionTestUtils.setField(hmsAppGroupRoles, "AppRolesName","ADMIN");
		Assert.assertEquals(hmsAppGroupRoles.getAppRolesName(), "ADMIN");
	}

	@Test
	public void testSetAppRolesName() {
		hmsAppGroupRoles.setAppRolesName("ADMIN");
		Assert.assertEquals(ReflectionTestUtils.getField(hmsAppGroupRoles, "AppRolesName"), "ADMIN");
	}

	

}
