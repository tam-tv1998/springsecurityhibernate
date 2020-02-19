package model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUser extends User{

	private static final long serialVersionUID = 1L;
	
	public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		this.id = long1;
	}
	
	

}
