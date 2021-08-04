package com.mursu.controller;

import com.mursu.model.Role;
import com.mursu.model.User;
import com.mursu.model.UserRole;
import com.mursu.service.UserService;
import com.mursu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    // creating user...
    @PostMapping("/")
    public User createUser(@RequestBody User user ) throws Exception {

        user.setProfile("default.png");

        //encoding password with BCryptPasswordEncoder...
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));


        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(41L);
        role.setRoleName("Normal");
        UserRole userRole =  new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);
       return  this.userService.createUser(user, roles);


    }


    // get user by username...
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){

        return this.userService.getUser(username);
    }

    // Delete User by UserId...
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);

    }


}
