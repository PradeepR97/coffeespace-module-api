package com.coffeespace.controller;

import com.coffeespace.dto.SendOtpRequest;
import com.coffeespace.dto.SendOtpResponse;
import com.coffeespace.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sendOtp")
    public ResponseEntity<SendOtpResponse> sendOtp(@RequestBody SendOtpRequest request) {
        return ResponseEntity.ok(authService.sendOtp(request));
    }
}
