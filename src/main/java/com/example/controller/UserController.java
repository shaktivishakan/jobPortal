package com.example.controller;


import com.example.dto.UserCreateRequest;
import com.example.dto.UserResponse;
import com.example.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("List of all job");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse response = new UserResponse(id, "placeholder" , "USER" , true , LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserCreateRequest userData){
        UserResponse response = new UserResponse(1L,userData.getName(), "USER", true, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody String userData){
        return ResponseEntity.ok("User updated "+ id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id)
    {
        return ResponseEntity.noContent().build();
    }

}
