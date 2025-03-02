package com.zosh.treading.service;

import com.zosh.treading.entity.TwoFactorOTP;
import com.zosh.treading.entity.User;

public interface TwoFactorOtpService {

    TwoFactorOTP createTowFactorOTP(User user, String otp, String jwt);

    TwoFactorOTP findByUser(Long userId);

    TwoFactorOTP findById(String id);

    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOtp, String otp);

    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOtp);



}
