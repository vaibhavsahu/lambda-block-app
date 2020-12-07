package com.vaibhav.lamdablock.lambdablockapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserResponse {
    private String status;
    private String error;
    private String authToken;
    private long expiresInMinutes;

    public UserResponse() {
    }
}
