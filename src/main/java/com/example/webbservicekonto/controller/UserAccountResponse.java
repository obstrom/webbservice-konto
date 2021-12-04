package com.example.webbservicekonto.controller;

import com.example.webbservicekonto.model.UserAccount;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAccountResponse {

    private final HttpStatus status;
    private final Date timestamp = new Date();
    private final String message;
    private final UserAccount entity;
    private final List<UserAccount> entities;

    public UserAccountResponse(HttpStatus status, String message, UserAccount entity) {
        this.status = status;
        this.message = message;
        this.entity = entity;
        this.entities = null;
    }

    public UserAccountResponse(HttpStatus status, String message, List<UserAccount> entities) {
        this.status = status;
        this.message = message;
        this.entity = null;
        this.entities = entities;
    }

    public UserAccountResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.entity = null;
        this.entities = null;
    }

}
