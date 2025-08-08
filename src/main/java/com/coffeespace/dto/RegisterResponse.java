package com.coffeespace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String goal;
    private List<String> priorities;
    private String experience;
    private List<String> skills;
    private List<String> industries;
    private LinkedInResponse linkedIn;
}
