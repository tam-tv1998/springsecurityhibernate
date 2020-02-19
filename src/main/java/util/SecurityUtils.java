package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.truongvantam.entity.Users;

import model.MyUser;

public class SecurityUtils {

	public static MyUser getPrincipal() {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}
	
	@SuppressWarnings(value = { "unchecked" })
	public static List<String> getAuthorities(){
		List<String> results = new ArrayList<String>();
		Set<GrantedAuthority> grantedAuthorities = (Set<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication();
		for(GrantedAuthority granted : grantedAuthorities) {
			results.add(granted.getAuthority());
		}
		return results;
	}
}
