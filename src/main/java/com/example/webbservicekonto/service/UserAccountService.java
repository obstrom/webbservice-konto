package com.example.webbservicekonto.service;

import com.example.webbservicekonto.model.UserAccount;
import com.example.webbservicekonto.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    // TODO - Add sorting?
    public List<UserAccount> findAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    public UserAccount findUserAccount(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("no user account with ID '" + id + "' found!"));
    }

    public void registerNewUserAccount( /* Need to know what fields User model has to take in */ ) {
        // TODO - Need to add proper validation, can only be done when User model is finished
    }

    // TODO
    //  - Add method "findUsersByName()" ?
    //  - Add method "findUsersByEmail()" ?

    public void updateUserAccount( /* Need to know what fields User model has to take in */ ) {
        // TODO - Need to add proper validation, can only be done when User model is finished
    }

    // TODO
    //  - Add method "updatePassword()" ?

    public void deleteUserAccount(Long id) {
        if (!userAccountRepository.existsById(id))
            throw new IllegalStateException("no account with ID '" + id + "' found!");

        userAccountRepository.deleteById(id);
    }

}
