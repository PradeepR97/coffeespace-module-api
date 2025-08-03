package com.coffeespace.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendOtpResponse {
    private String message;
    private int statusCode;
    private boolean success;
    private OtpData data;

    @Data
    @Builder
    public static class OtpData {
        private String otp;
        private long expiryInSeconds;
    }
}
