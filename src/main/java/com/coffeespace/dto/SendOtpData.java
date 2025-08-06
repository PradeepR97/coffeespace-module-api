package com.coffeespace.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendOtpData {
    private String otp;
    private int expiryInSeconds;
}
