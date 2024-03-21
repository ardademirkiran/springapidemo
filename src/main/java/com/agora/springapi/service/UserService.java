package com.agora.springapi.service;

import com.agora.springapi.entity.Users;
import com.agora.springapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticateUser(String uname, String password) {
        return userRepository.existsByUnameAndPassword(uname, password);
    }

    public boolean checkIfUnameExists(String uname){
        return userRepository.existsByUname(uname);
    }

    public boolean checkIfEmailInUse(String email) {
        return userRepository.existsByEmail(email);
    }

    public Users createAndFlush(String uname, String email, String password){
        Users newUsers = new Users();
        newUsers.setUname(uname);
        newUsers.setEmail(email);
        newUsers.setPassword(password);

        return userRepository.saveAndFlush(newUsers);
    }
}