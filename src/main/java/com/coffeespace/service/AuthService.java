package com.coffeespace.service;

import com.coffeespace.dto.SendOtpRequest;
import com.coffeespace.dto.SendOtpResponse;
import com.coffeespace.entity.Otp;
import com.coffeespace.repository.OtpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final OtpRepository otpRepository;

    public SendOtpResponse sendOtp(SendOtpRequest request) {
        String staticOtp = "1111";
        int expiryInSeconds = 500;

        Otp otp = Otp.builder()
                .phoneNumber(request.getPhoneNumber())
                .otp(staticOtp)
                .expiryTime(LocalDateTime.now().plusSeconds(expiryInSeconds))
                .build();

        otpRepository.save(otp);

        return SendOtpResponse.builder()
                .message("OTP generated and sent successfully")
                .statusCode(200)
                .success(true)
                .data(SendOtpResponse.OtpData.builder()
                        .otp(staticOtp)
                        .expiryInSeconds(expiryInSeconds)
                        .build())
                .build();
    }
}
