package com.example.webbservicekonto.controller;

import com.example.webbservicekonto.model.UserAccount;
import com.example.webbservicekonto.service.UserAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:xxxx", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")

public class AccountController {

    @Autowired
    private UserAccountService UserAccountService;

    @GetMapping(path = "/users", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserAccountResponse> getAllUsers() {
        List<UserAccount> allUserAccounts = UserAccountService.findAllUserAccounts();

        return ResponseEntity.ok().body(new UserAccountResponse(HttpStatus.OK, "Success retrieving all user accounts", allUserAccounts));
    }

    @GetMapping(path = "/users/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserAccountResponse> getUsersById(@PathVariable(value = "id") Long userId) {
        UserAccount userAccount = UserAccountService.findUserAccount(userId);

        return ResponseEntity.ok().body(new UserAccountResponse(HttpStatus.OK, "User account with ID " + userId + " found", userAccount));
    }

    @PostMapping(path = "/users", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserAccountResponse> createUser(@RequestBody UserAccount user) {
        UserAccount userAccount = UserAccountService.registerNewUserAccount(user);

        return ResponseEntity.ok().body(new UserAccountResponse(HttpStatus.OK, "New account created successfully", userAccount));
    }

    @PutMapping(path = "/users/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserAccountResponse> updateUser(@PathVariable(value = "id") Long userId, @RequestBody UserAccount userDetails) {
        UserAccount userAccount = UserAccountService.updateUserAccount(userId, userDetails.getName(), userDetails.getEmail(), userDetails.getPassword());

        return ResponseEntity.ok().body(new UserAccountResponse(HttpStatus.OK, "Account updated successfully", userAccount));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserAccountResponse> DeleteUser (@PathVariable(value="id") Long userId) {
        UserAccountService.deleteUserAccount(userId);

        return ResponseEntity.ok().body(new UserAccountResponse(HttpStatus.OK, "Account deleted successfully"));
    }
}