package com.coffeespace.dto;

import lombok.Data;

import java.util.List;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String goal;
    private List<String> priorities;
    private String experience;
    private List<String> skills;
    private List<String> industries;

    private String linkedInProfileUrl;
    private String linkedInName;
    private String linkedInSummary;
    private List<LinkedInExperienceDTO> linkedInExperience;
    private List<LinkedInEducationDTO> linkedInEducation;
    private List<String> linkedInSkills;
    private Integer linkedInConnectionsCount;
}
