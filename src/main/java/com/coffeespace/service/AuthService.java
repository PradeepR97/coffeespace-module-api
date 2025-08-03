package com.coffeespace.service;

import com.coffeespace.dto.SendOtpRequest;
import com.coffeespace.dto.SendOtpResponse;
import com.coffeespace.dto.VerifyOtpRequest;
import com.coffeespace.dto.VerifyOtpResponse;
import com.coffeespace.entity.Otp;
import com.coffeespace.repository.OtpRepository;
import com.coffeespace.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final OtpRepository otpRepository;
    private final JwtUtil jwtUtil;

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

    public VerifyOtpResponse verifyOtp(VerifyOtpRequest request) {
        Optional<Otp> latestOtpOpt = otpRepository
                .findTopByPhoneNumberOrderByExpiryTimeDesc(request.getPhoneNumber());

        if (latestOtpOpt.isEmpty()) {
            return buildError("Invalid phone number", 400);
        }

        Otp latestOtp = latestOtpOpt.get();

        if (!latestOtp.getOtp().equals(request.getOtp()) ||
                latestOtp.getExpiryTime().isBefore(LocalDateTime.now())) {
            return buildError("Invalid or expired OTP", 400);
        }

        String token = jwtUtil.generateToken(request.getPhoneNumber());

        return VerifyOtpResponse.builder()
                .message("OTP verified successfully")
                .statusCode(200)
                .success(true)
                .data(VerifyOtpResponse.DataObj.builder()
                        .token(token)
                        .profileId(null) // Add user lookup if needed
                        .build())
                .build();
    }

    private VerifyOtpResponse buildError(String msg, int status) {
        return VerifyOtpResponse.builder()
                .message(msg)
                .statusCode(status)
                .success(false)
                .data(null)
                .build();
    }
}
