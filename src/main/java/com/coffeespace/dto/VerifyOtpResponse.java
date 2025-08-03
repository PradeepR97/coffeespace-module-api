package com.coffeespace.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyOtpResponse {
    private String message;
    private int statusCode;
    private boolean success;
    private DataObj data;

    @Data
    @Builder
    public static class DataObj {
        private String token;
        private String profileId; // null or actual ID
    }
}
