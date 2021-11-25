package com.example.webbservicekonto.repository;

import com.example.webbservicekonto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // TODO
    //  - Add query for finding user(s) by name?
    //  - Add query for finding user(s) by email?
}
