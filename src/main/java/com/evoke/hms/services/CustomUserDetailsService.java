package com.evoke.hms.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.evoke.hms.business.HMSAppGroupRolesBusinesModel;
import com.evoke.hms.business.IHMSUserBusinessModel;



/**
 * Checks user details for security login
 * @author rpasupuleti
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

	private IUserService userService;

	@Autowired 
	public void setIUserServices(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		IHMSUserBusinessModel hmsUser = null;
		try {
			hmsUser = userService.findByUsername(userName);
		} catch (Exception e) {
			LOGGER.debug("User details not found for user {} and loginId: {}",userName, hmsUser.getUserLoginId());
			throw new UsernameNotFoundException("User details not found for loginId::{}"+ userName);
		}
		LOGGER.debug("Found user details for user and loginId: {}",hmsUser.getUserLoginId());
		return new User(
				hmsUser.getUserLoginId(),
				hmsUser.getUserPassword(),
				getAuthorities(hmsUser.getAppGroupRoles()));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Collection<HMSAppGroupRolesBusinesModel> set) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(set));
		return authList;
	}

	public List<String> getRoles(Collection<HMSAppGroupRolesBusinesModel> set) {
		List<String> roles = new ArrayList<String>();
		Iterator<HMSAppGroupRolesBusinesModel> itr =set.iterator();
		while(itr.hasNext()){
			roles.add(itr.next().getAppRolesName());
		}
		LOGGER.debug("Roles of User: {}",roles);
		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}


