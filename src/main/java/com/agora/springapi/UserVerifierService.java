package com.agora.springapi;

import com.agora.springapi.UserVerifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVerifierService {

    private final UserVerifierRepository userRepository;

    @Autowired
    public UserVerifierService(UserVerifierRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticateUser(String uname, String password) {
        return userRepository.existsByUnameAndPassword(uname, password);
    }
}