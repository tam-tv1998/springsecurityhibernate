package com.truongvantam.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.truongvantam.entity.Users;
import com.truongvantam.imp.UserDetailImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDetailDAO implements UserDetailImp {

	@Autowired
	SessionFactory mySessionFactory;
	
	@Transactional
	public Users findUserByUserName(String username) {
		Session session = mySessionFactory.getCurrentSession();
		String sql = "from users where username = '"+ username + "'";
		Users users = (Users) session.createQuery(sql).getSingleResult();
		return users;
	}

}
