package com.example.webbservicekonto.service;

import com.example.webbservicekonto.model.UserAccount;
import com.example.webbservicekonto.repository.UserAccountRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    // TODO
    //  - Add method "getUsersByName()" ?
    //  - Add method "getUsersByEmail()" ?

    public void registerNewUserAccount(UserAccount userAccount) {
        if (isStringEmpty(userAccount.getName()))
            throw new IllegalStateException("new user account requires a name");

        if (isStringEmpty(userAccount.getEmail()))
            throw new IllegalStateException("new user account requires an email");

        if (isStringEmpty(userAccount.getPassword()))
            throw new IllegalStateException("new user account requires a password");

        userAccountRepository.save(userAccount);
    }

    @Transactional
    public void updateUserAccount(@NonNull Long id, String newName, String newEmail, String newPassword) {
        boolean anyFieldsUpdated = false;
        UserAccount account = userAccountRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("no user account with ID '" + id + "' found!"));

        if (!isStringEmpty(newName) && isStringsNotEqual(account.getName(), newName)) {
            account.setName(newName);
            anyFieldsUpdated = true;
        }

        if (!isStringEmpty(newEmail) && isStringsNotEqual(account.getEmail(), newEmail)) {
            account.setEmail(newEmail);
            anyFieldsUpdated = true;
        }

        if (!isStringEmpty(newPassword) && isStringsNotEqual(account.getPassword(), newPassword)) {
            // TODO - Add Security?
            //  - Hash and salt?
            account.setPassword(newPassword);
            anyFieldsUpdated = true;
        }

        if (anyFieldsUpdated) userAccountRepository.save(account);
    }

    public void deleteUserAccount(Long id) {
        if (!userAccountRepository.existsById(id))
            throw new IllegalStateException("no account with ID '" + id + "' found!");

        userAccountRepository.deleteById(id);
    }

    private boolean isStringEmpty(String string) {
        return string == null || string.equals("");
    }

    private boolean isStringsNotEqual(String string1, String string2) {
        return string1.strip().equals(string2.strip());
    }

}
