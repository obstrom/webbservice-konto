package com.example.webbservicekonto.repository;

import com.example.webbservicekonto.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    List<UserAccount> findUserAccountsByName(String name);
    List<UserAccount> findUserAccountsByEmail(String email);
}
