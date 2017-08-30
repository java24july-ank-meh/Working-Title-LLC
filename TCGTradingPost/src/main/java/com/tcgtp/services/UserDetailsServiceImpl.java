package com.tcgtp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcgtp.domain.User;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserService userService;
	private Converter<User, UserDetails> user2DetailsConverter;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	@Qualifier(value = "user2UserDetails")
	public void setUser2DetailsConverter(Converter<User, UserDetails> user2DetailsConverter) {
		this.user2DetailsConverter = user2DetailsConverter;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return user2DetailsConverter.convert(userService.findByUsername(username));
	}

}
