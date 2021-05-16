package com.example.productstore;

import java.util.Collection;
import java.util.Collections;

public class UserPrinciple{

	private user users;
	

	public UserPrinciple(user users) {
		super();
		this.users = users;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return Collections.singleton(new SimpleGrantedAuthority(getUsername()));
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return users.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return users.getUsername();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
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

}
