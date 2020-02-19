package com.truongvantam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truongvantam.dao.SanPhamDAO;
import com.truongvantam.entity.SanPham;
import com.truongvantam.imp.SanPhamImp;

@Service
public class SanPhamService implements SanPhamImp {

	@Autowired
	SanPhamDAO sanPhamDAO;
	
	public void addSanPham(SanPham sanPham) {
		sanPhamDAO.addSanPham(sanPham);
	}

}
