package com.mursu.service;


import com.mursu.model.User;
import com.mursu.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
 public interface UserService {

    // Create User
    public User createUser(User user , Set<UserRole> userRoles) throws Exception;

    // get User...
    public User getUser(String username);

    // delete user by id...
    public  void  deleteUser(Long userId);

}
