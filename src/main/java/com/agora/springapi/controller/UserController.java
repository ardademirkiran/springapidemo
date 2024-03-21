package com.agora.springapi.controller;

import com.agora.springapi.request.LoginRequest;
import com.agora.springapi.request.SignupRequest;
import com.agora.springapi.response.LoginResponse;
import com.agora.springapi.response.SignupResponse;
import com.agora.springapi.result.Result;
import com.agora.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usermanagement")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = userService.authenticateUser(loginRequest.getUname(), loginRequest.getPassword());

        if (isAuthenticated) {
            return ResponseEntity.ok().body(new LoginResponse(new Result("L1", "Authorization successful.")));
        } else {
            return ResponseEntity.ok().body(new LoginResponse(new Result("L0", "Invalid username or password.")));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody SignupRequest signupRequest){
        boolean isUnameTaken = userService.checkIfUnameExists(signupRequest.getUname());
        boolean isEmailInUse = userService.checkIfEmailInUse(signupRequest.getEmail());
        if(!isUnameTaken && !isEmailInUse){
            userService.createAndFlush(signupRequest.getUname(), signupRequest.getEmail(), signupRequest.getPassword());
            return ResponseEntity.ok().body(new SignupResponse(new Result("S1", "Signup is successful, new user is created.")));
        } else if (isUnameTaken) {
            return ResponseEntity.ok().body(new SignupResponse(new Result("S0", "Username is already in use,  new user is NOT created.")));
        } else {
            return ResponseEntity.ok().body(new SignupResponse(new Result("S2", "Email is already in use,  new user is NOT created.")));
        }
    }
}