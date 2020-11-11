package com.pgbezerra.hroauth.services;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pgbezerra.hroauth.entities.User;
import com.pgbezerra.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		if(Objects.isNull(user)) {
			logger.error(String.format("Email not found: %s", username));
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info(String.format("Email found: %s" , username));
		return user;
	}

	
}
