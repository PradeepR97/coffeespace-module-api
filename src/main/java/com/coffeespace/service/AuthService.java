package com.coffeespace.service;

import com.coffeespace.constants.ResponseConstants;
import com.coffeespace.dto.*;
import com.coffeespace.entity.Otp;
import com.coffeespace.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final OtpService otpService;
    private final JwtUtil jwtUtil;

    public ApiResponse<SendOtpData> sendOtp(SendOtpRequest request) {
        String staticOtp = "1111";
        int expiryInSeconds = 500;

        Otp otp = Otp.builder()
                .phoneNumber(request.getPhoneNumber())
                .otp(staticOtp)
                .expiryTime(LocalDateTime.now().plusSeconds(expiryInSeconds))
                .build();

        otpService.saveOtp(otp);

        return ApiResponse.<SendOtpData>builder()
                .message(ResponseConstants.OTP_SENT)
                .statusCode(ResponseConstants.SUCCESS_CODE)
                .success(true)
                .data(SendOtpData.builder()
                        .otp(staticOtp)
                        .expiryInSeconds(expiryInSeconds)
                        .build())
                .build();
    }

    public ApiResponse<VerifyOtpData> verifyOtp(VerifyOtpRequest request) {
        if (request == null ||
                request.getPhoneNumber() == null || request.getPhoneNumber().isBlank() ||
                request.getOtp() == null || request.getOtp().isBlank()) {
            return buildError(ResponseConstants.INVALID_PHONE, ResponseConstants.BAD_REQUEST_CODE);
        }

        Optional<Otp> latestOtpOpt = otpService.getLatestOtpByPhone(request.getPhoneNumber());

        if (latestOtpOpt.isEmpty()) {
            return buildError(ResponseConstants.INVALID_PHONE, ResponseConstants.BAD_REQUEST_CODE);
        }

        Otp latestOtp = latestOtpOpt.get();

        if (!latestOtp.getOtp().equals(request.getOtp()) ||
                latestOtp.getExpiryTime().isBefore(LocalDateTime.now())) {
            return buildError(ResponseConstants.INVALID_OR_EXPIRED_OTP, ResponseConstants.BAD_REQUEST_CODE);
        }

        String token = jwtUtil.generateToken(request.getPhoneNumber());

        return ApiResponse.<VerifyOtpData>builder()
                .message(ResponseConstants.OTP_VERIFIED)
                .statusCode(ResponseConstants.SUCCESS_CODE)
                .success(true)
                .data(VerifyOtpData.builder()
                        .token(token)
                        .profileId(null)
                        .build())
                .build();
    }

    private ApiResponse<VerifyOtpData> buildError(String msg, int status) {
        return ApiResponse.<VerifyOtpData>builder()
                .message(msg)
                .statusCode(status)
                .success(false)
                .data(null)
                .build();
    }
}
