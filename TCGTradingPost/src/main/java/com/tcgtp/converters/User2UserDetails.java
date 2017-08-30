package com.tcgtp.converters;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.tcgtp.domain.User;
import com.tcgtp.services.UserDetailsImpl;

// Converter from User object to UserDetails object for use by Spring Security
@Component
public class User2UserDetails implements Converter<User, UserDetails> {

	@Override
	public UserDetails convert(User source) {
		UserDetailsImpl userDetails = new UserDetailsImpl();
		
		if (source == null) {
			return userDetails;
		}
		
		userDetails.setUsername(source.getUsername());
		userDetails.setPassword(source.getEncryptedPassword());
		userDetails.setEnabled(source.getEnabled());
		
		Collection<SimpleGrantedAuthority> authoritiesColl = new ArrayList<>();
		source.getRoles().forEach(
				// Lambda method to add each of source's roles to authoritiesColl
				role -> {
					authoritiesColl.add(new SimpleGrantedAuthority(role.getRoleName()));
				}
				);
		userDetails.setAuthorities(authoritiesColl);
		
		return userDetails;
	}
	
}
