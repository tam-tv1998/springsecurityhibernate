package com.truongvantam.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.truongvantam.entity.SanPham;
import com.truongvantam.imp.SanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp {

	@Autowired
	SessionFactory mySessionFactory;
	
	@Transactional
	public void addSanPham(SanPham sanPham) {
		Session session = mySessionFactory.getCurrentSession();
		session.save(sanPham);
	}

}
