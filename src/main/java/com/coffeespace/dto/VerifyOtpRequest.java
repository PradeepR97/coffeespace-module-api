package com.coffeespace.dto;

import lombok.Data;

@Data
public class VerifyOtpRequest {
    private String phoneNumber;
    private String otp;
}
