package com.truongvantam.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.truongvantam.dao.UserDetailDAO;
import com.truongvantam.entity.Users;
import com.truongvantam.imp.UserDetailImp;

public class UserService implements UserDetailImp {

	@Autowired
	UserDetailDAO userDetailDAO;

	public Users findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
