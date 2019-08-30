package com.LTR.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.LTR.entity.UserRole;
import com.LTR.service.UserService;


@Service("authService")
public class AuthenticationServiceImpl implements UserDetailsService{
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
	private static final Log LOG = LogFactory.getLog(AuthenticationServiceImpl.class);
	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		com.LTR.entity.User user = userServiceImpl.getOne(userName);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());		
		return buildUser(user, authorities);
				
	}
	
	private User buildUser(com.LTR.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(), user.isEnable(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
		
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();

		for (UserRole userRole : userRoles) {
			LOG.info("EL ROLES ES:"+userRole.getRole());
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		LOG.info("EL GrantedAuthority ES:"+auths.toString());

		return new ArrayList<GrantedAuthority>(auths);
	}
	
	
	

}
