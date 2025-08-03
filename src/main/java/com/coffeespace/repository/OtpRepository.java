package com.coffeespace.repository;

import com.coffeespace.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findTopByPhoneNumberOrderByExpiryTimeDesc(String phoneNumber);
}
