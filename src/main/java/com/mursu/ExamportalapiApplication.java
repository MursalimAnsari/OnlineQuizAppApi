package com.mursu;

import com.mursu.model.Role;
import com.mursu.model.User;
import com.mursu.model.UserRole;
import com.mursu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamportalapiApplication  implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamportalapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Starting code...");

	/*
		User  user = new User();

		user.setFirstName("mursu");
		user.setLastName("mursu");
		user.setUsername("mursu01");
        user.setPassword(this.bCryptPasswordEncoder.encode("mursu01"));
        user.setEmail("mursu01@gmail.com");	
        user.setProfile("default.png");

		Role role1 = new Role();
		role1.setRoleId(40L);
		role1.setRoleName("Admin");

		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);

		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());

*/


	}
}
