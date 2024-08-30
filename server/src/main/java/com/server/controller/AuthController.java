package com.server.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.bean.Users;
import com.server.dto.LoginDTO;
import com.server.dto.RegisterDTO;
import com.server.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        Optional<Users> op = userService.getUser(loginDTO.getUserName());
        if(op.isPresent()){
            Users user = op.get();
            if(user.getPassword() == loginDTO.getPassword()){
                return ResponseEntity.ok("Login Successful");
            }
            else{
                return ResponseEntity.badRequest().body("Password Mismatch");
            }
            
        }
        else{
            return ResponseEntity.badRequest().body("User Not Found");
        } 
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO ){
        Users newUser = new Users();
        String userName =  registerDTO.getEmail().substring(0, registerDTO.getEmail().indexOf('@'));
        Optional<Users> op = userService.getUser(userName);
        if (!op.isPresent()) {
            newUser.setUsername(userName);
            newUser.setFullName(registerDTO.getFullName());
            newUser.setEmail(registerDTO.getEmail());
            newUser.setPassword(registerDTO.getPassword());
            userService.saveUser(newUser);
            return ResponseEntity.ok("Successful Registered "+userName);
        }
        else{
            return ResponseEntity.badRequest().body("User already exists");
        }

    }
}
