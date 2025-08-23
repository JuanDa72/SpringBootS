package com.SpringFirstAttempt.sfa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public Users registrer(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);

    }

}
