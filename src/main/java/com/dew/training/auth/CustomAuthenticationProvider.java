package com.dew.training.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.dew.training.dto.User;
import com.dew.training.enums.UserRole;
import com.dew.training.service.UserService;
import com.dew.training.util.GeneralUtils;


@Component(value="customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired UserService userService;
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
			User user = new User();
			user = (User)authentication.getPrincipal();
			String password=GeneralUtils.encrypt(authentication.getCredentials().toString());
			user.setPassword(password);
			System.out.println(user.getEmail()+"=============");
			user = userService.signIn(user);
			if (user == null) {
				throw new UsernameNotFoundException(String.format("Invalid credentials", authentication.getPrincipal()));
			}

			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			/*
			 * Permission rolePermissions = user.getUserType(); for (Permission
			 * permission : rolePermissions) { }
			 */
			grantedAuthorities.add(new SimpleGrantedAuthority(UserRole.ROLE_USER.toString()));

			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), null, grantedAuthorities);

			return token;
		} catch (Exception e) {
			//logger.println(IMessage.ERROR, "CustomAuthenticationProvider.authenticate()", e);
			throw new AuthenticationServiceException(e.getMessage());
		}
	}

	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
