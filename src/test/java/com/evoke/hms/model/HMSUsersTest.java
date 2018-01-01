package com.evoke.hms.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class HMSUsersTest {

	private HMSUser hmsUser;
	
	private HMSAppGroupRoles hmsAppGroupRoles;

	@Before
	public void setUp() throws Exception{
		hmsUser = new HMSUser();
		hmsAppGroupRoles = new HMSAppGroupRoles();
	}

	@Test
	public void testGetUserLoginId() {
		ReflectionTestUtils.setField(hmsUser, "userLoginId", "testLoginId");
		Assert.assertEquals(hmsUser.getUserLoginId(), "testLoginId");
	}

	@Test
	public void testSetUserLoginId() {
		String loginId = "testLoginId";
		hmsUser.setUserLoginId(loginId);
		Assert.assertEquals(loginId, ReflectionTestUtils.getField(hmsUser, "userLoginId"));
	}

	@Test
	public void testGetUserPassword() {
		//TODO: Need to be implement with Hash After adding registration 
		ReflectionTestUtils.setField(hmsUser, "userPassword", "password");
		Assert.assertEquals(hmsUser.getUserPassword(), "password");
	}

	@Test
	public void testSetUserPassword() {
		hmsUser.setUserPassword("password");
		Assert.assertEquals(ReflectionTestUtils.getField(hmsUser, "userPassword"), "password");
	}

	@Test
	public void testGetCreatedOn() {
		Date date = java.sql.Date.valueOf("2015-12-20");
		ReflectionTestUtils.setField(hmsUser, "createdOn", date);
		Assert.assertEquals(hmsUser.getCreatedOn(), date);
	}

	@Test
	public void testSetCreatedOn() {
		Date date = java.sql.Date.valueOf("2015-12-20");
		hmsUser.setCreatedOn(date);
		Assert.assertEquals(ReflectionTestUtils.getField(hmsUser, "createdOn"), date);
	}

	
	@Test
	public void testGetLastLoginDate() {
		Date date = java.sql.Date.valueOf("2015-12-20");
		ReflectionTestUtils.setField(hmsUser, "lastLoginDate", date);
		Assert.assertEquals(hmsUser.getLastLoginDate(), date);
	}

	@Test
	public void testSetLastLoginDate() {
		Date date = java.sql.Date.valueOf("2015-12-20");
		hmsUser.setLastLoginDate(date);
		Assert.assertEquals(ReflectionTestUtils.getField(hmsUser, "lastLoginDate"), date);
	}

	
	@Test
	public void testGetCreatedBy() {
		ReflectionTestUtils.setField(hmsUser, "createdBy", "Ramu");
		Assert.assertEquals(hmsUser.getCreatedBy(), "Ramu");
	}

	@Test
	public void testSetCreatedBy() {
		hmsUser.setCreatedBy("Ramu");
		Assert.assertEquals(ReflectionTestUtils.getField(hmsUser, "createdBy"), "Ramu");
	}

	@Test
	public void testGetLastModifiedOn() {
		Date date = java.sql.Date.valueOf("2015-12-20");
		ReflectionTestUtils.setField(hmsUser, "lastModifiedOn", date);
		Assert.assertEquals(hmsUser.getLastModifiedOn(), date);
	}

	@Test
	public void testSetLastModifiedOn() {
		Date date = java.sql.Date.valueOf("2015-12-20");
		hmsUser.setLastModifiedOn(date);	
		Assert.assertEquals(ReflectionTestUtils.getField(hmsUser, "lastModifiedOn"), date);
	}

	@Test
	public void testGetLastModifiedBy() {
		ReflectionTestUtils.setField(hmsUser, "lastModifiedBy", "Ramu");
		Assert.assertEquals(hmsUser.getLastModifiedBy(), "Ramu");
	}

	@Test
	public void testSetLastModifiedBy() {
		hmsUser.setLastModifiedBy("Ramu");
		Assert.assertEquals(ReflectionTestUtils.getField(hmsUser, "lastModifiedBy"), "Ramu");
	}

	@Test
	public void testGetStatus() {
		ReflectionTestUtils.setField(hmsUser, "status", "Active");
		Assert.assertEquals(hmsUser.getStatus(), "Active");
	}

	@Test
	public void testSetStatus() {
		hmsUser.setStatus("Active");
		Assert.assertEquals(ReflectionTestUtils.getField(hmsUser, "status"), "Active");
	}

	@Test
	public void testGetIPAddress() {
		ReflectionTestUtils.setField(hmsUser, "IPAddress", "10.78.152.85");
		Assert.assertEquals( hmsUser.getIPAddress(), "10.78.152.85");
	}

	@Test
	public void testSetIPAddress() {
		hmsUser.setIPAddress("10.78.152.85");
		Assert.assertEquals( ReflectionTestUtils.getField(hmsUser, "IPAddress"), "10.78.152.85");
	}

	@Test
	public void testGetAppGroupRoles() {
		Set<HMSAppGroupRoles> appGroupRoles = new HashSet<HMSAppGroupRoles>();
		ReflectionTestUtils.setField(hmsUser, "AppGroupRoles", appGroupRoles);
		Assert.assertEquals(appGroupRoles,hmsUser.getAppGroupRoles());
	}

	@Test
	public void testSetAppGroupRoles() {
		Set<HMSAppGroupRoles> appGroupRoles = new HashSet<HMSAppGroupRoles>();
		hmsAppGroupRoles.setAppRolesName("ADMIN");
		appGroupRoles.add(hmsAppGroupRoles);
		hmsUser.setAppGroupRoles(appGroupRoles);
		Assert.assertEquals(appGroupRoles,ReflectionTestUtils.getField(hmsUser, "AppGroupRoles"));
	}

}
