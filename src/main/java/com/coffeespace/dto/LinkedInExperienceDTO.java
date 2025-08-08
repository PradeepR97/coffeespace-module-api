package com.coffeespace.dto;

import lombok.Data;

@Data
public class LinkedInExperienceDTO {
    private String title;
    private String company;
    private String startDate; // "YYYY-MM-DD"
    private String endDate;   // or null
    private String location;
    private boolean isCurrent;
}
