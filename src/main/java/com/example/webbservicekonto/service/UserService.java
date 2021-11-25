package com.example.webbservicekonto.service;

import com.example.webbservicekonto.model.User;
import com.example.webbservicekonto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO - Add sorting?
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("no user with ID '" + userId + "' found!"));
    }

    public void registerNewUser( /* Need to know what fields User model has to take in */ ) {
        // TODO - Need to add proper validation, can only be done when User model is finished
    }

    // TODO
    //  - Add method "findUsersByName()" ?
    //  - Add method "findUsersByEmail()" ?

    public void updateUser( /* Need to know what fields User model has to take in */ ) {
        // TODO - Need to add proper validation, can only be done when User model is finished
    }

    // TODO
    //  - Add method "updatePassword()" ?

    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId))
            throw new IllegalStateException("no user with ID '" + userId + "' found!");

        userRepository.deleteById(userId);
    }

}
