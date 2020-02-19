package com.truongvantam.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.truongvantam.dao.UserDetailDAO;
import com.truongvantam.entity.Role;
import com.truongvantam.entity.Users;

import model.MyUser;

@Service("myUserDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserDetailDAO userDetailDAO;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = userDetailDAO.findUserByUserName(username);
		UserBuilder userBuilder = null;
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		
		Set<Role> roles = user.getRoles();
		
		for(Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		
//		return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
		MyUser myUser = new MyUser(user.getUsername(), user.getPassword(), grantedAuthorities);
		myUser.setId(user.getId_user());
		return myUser;
		
	}

}
