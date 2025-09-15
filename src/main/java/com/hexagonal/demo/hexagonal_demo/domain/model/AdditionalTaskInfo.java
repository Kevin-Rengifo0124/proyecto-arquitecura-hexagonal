package com.hexagonal.demo.hexagonal_demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public class AdditionalTaskInfo {

    private final Long userId;
    private final String userName;
    private final String userEmail;

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
