package com.server.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.bean.Users;
import com.server.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String saveUser(Users user){
        userRepo.save(user);
        return "User Saved";
    }

    public Users getUser(String userName){
        return userRepo.findByUserName(userName);

    }

}
