package com.tcgtp.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// Implements Spring Security's UserDetails interface with additional methods for user info
public class UserDetailsImpl implements UserDetails {

	private Collection<SimpleGrantedAuthority> authoritiesColl;
    private String username;
    private String password;
    private Boolean enabled = true;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authoritiesColl;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	// Additional methods
	public void setAuthorities(Collection<SimpleGrantedAuthority> authoritiesColl) {
		this.authoritiesColl = authoritiesColl;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
