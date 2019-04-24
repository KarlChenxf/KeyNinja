package com.xfchen.mySite;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xfchen.mySite.domain.User;
import com.xfchen.mySite.domain.security.Role;
import com.xfchen.mySite.domain.security.UserRole;
import com.xfchen.mySite.service.UserService;
import com.xfchen.mySite.utility.SecurityUtility;

@SpringBootApplication
public class MySiteApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MySiteApplication.class, args);
	}
	
	@Autowired
	UserService userService;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("xf");
		user1.setLastName("c");
		user1.setUsername("Admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("123"));
		user1.setEmail("chenxf_1996@163.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1,role1));
		
		userService.createUser(user1, userRoles);
	}

}
