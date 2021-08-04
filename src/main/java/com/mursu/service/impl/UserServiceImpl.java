package com.mursu.service.impl;

import com.mursu.helper.UserFoundException;
import com.mursu.model.User;
import com.mursu.model.UserRole;
import com.mursu.repo.RoleRepository;
import com.mursu.repo.UserRepository;
import com.mursu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
         User local = this.userRepository.findByUsername(user.getUsername());

         if(local!=null){
             System.out.println("User already exists...");
             throw new UserFoundException("User already present");
         }
         else {
             //create user...
             for(UserRole ur: userRoles){
                 roleRepository.save(ur.getRole());
             }
           user.getUserRoles().addAll(userRoles);
             local = this.userRepository.save(user);

         }

        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
          this.userRepository.deleteById(userId);
    }
}
