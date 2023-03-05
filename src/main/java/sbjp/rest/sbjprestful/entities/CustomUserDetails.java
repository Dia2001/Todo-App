package sbjp.rest.sbjprestful.entities;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.Data;
import sbjp.rest.sbjprestful.enums.RoleEnum;



public class CustomUserDetails{}
//implements UserDetails {
//	User user;
//
//	public CustomUserDetails(User user) {
//		super();
//		this.user = user;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		 return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return  user.getUserName();
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "CustomUserDetails [user=" + user + "]";
//	}
//
//}
