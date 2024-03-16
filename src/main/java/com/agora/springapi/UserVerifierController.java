package com.agora.springapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usermanagement/verify")
public class UserVerifierController {

    private final UserVerifierService userService;

    @Autowired
    public UserVerifierController(UserVerifierService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody users users) {
        boolean isAuthenticated = userService.authenticateUser(users.getUname(), users.getPassword());

        if (isAuthenticated) {
            return ResponseEntity.ok().body(new LoginResponse(new LoginResult(1, "User exists on Database. Authentication is successfull.")));
        } else {
            return ResponseEntity.badRequest().body(new LoginResponse(new LoginResult(0, "Invalid username or password")));
        }
    }
}