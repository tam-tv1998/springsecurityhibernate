package com.truongvantam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.truongvantam.entity.SanPham;
import com.truongvantam.service.SanPhamService;

import util.SecurityUtils;

@Controller
public class HomeController {

	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin") 
    public String admin() {
        return "admin";
    }
    
    @GetMapping("/admin/them") 
    public String themSP() {
        return "themsp";
    }
    
    @PostMapping("/admin/themss")
    public String themSP(@RequestParam("tenSP") String tenSP, @RequestParam("gia") String gia) {
    	
    	int giaSP = Integer.parseInt(gia);
    	
    	SanPham sanPham = new SanPham();
    	sanPham.setTenSP(tenSP);
    	sanPham.setGia(giaSP);
    	sanPham.setId_user(SecurityUtils.getPrincipal().getId());
    	sanPhamService.addSanPham(sanPham);
    	return "themsp";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/login") 
    public String getLogin() {
        return "login";
    }
    
    @GetMapping("/user")
    public String user() {
		return "user";
	}
    
    @GetMapping("/logout")
    public String logout(final Model model) {
      model.addAttribute("message", "Logged out!");
      return "login";
    }
}
