package com.pgbezerra.hroauth.services;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgbezerra.hroauth.entities.User;
import com.pgbezerra.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if(Objects.isNull(user)) {
			logger.error(String.format("Email not found: %s", email));
			throw new IllegalArgumentException("Email not found");
		}
		logger.info(String.format("Email found: %s" , email));
		return user;
	}
	
}
