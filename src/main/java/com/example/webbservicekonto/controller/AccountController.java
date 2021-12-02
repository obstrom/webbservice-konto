package com.example.webbservicekonto.controller;

import com.example.webbservicekonto.model.UserAccount;
import com.example.webbservicekonto.service.UserAccountService;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class AccountController {

    @Autowired
    private UserAccountService UserAccountService;
    @GetMapping("/users")
    public List<UserAccount> getAllUsers() {
        return UserAccountService.findAllUserAccounts();
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<UserAccount> getUsersById(@PathVariable(value = "id") Long userId) {
        UserAccount userAccount =
                UserAccountService.findUserAccount(userId);



        return ResponseEntity.ok().body(userAccount);}


    @PostMapping("/users")
    public void createUser(@RequestBody UserAccount user) {
        UserAccountService.registerNewUserAccount(user);}

    @PutMapping("/users/{id}")
    public void updateUser(
            @PathVariable(value = "id") Long userId, @RequestBody UserAccount userDetails) {

        UserAccountService.updateUserAccount(userId, userDetails.getName(), userDetails.getEmail(), userDetails.getPassword()); }
}