package com.zosh.treading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.treading.entity.TwoFactorOTP;

public interface TwoFactorOtpRepository extends JpaRepository<TwoFactorOTP, String> {

    TwoFactorOTP findByUserId(Long userId);

}
