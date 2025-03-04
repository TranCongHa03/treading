package com.zosh.treading.service;

import com.zosh.treading.domain.VerificationType;
import com.zosh.treading.entity.ForgotPasswordToken;
import com.zosh.treading.entity.User;

public interface ForgotPasswordService {

    ForgotPasswordToken createToken(User user, String id, String otp, VerificationType verificationType, String sendTo);

    ForgotPasswordToken findById(String id);

    ForgotPasswordToken findByUser(Long userId);

    void deleteToken(ForgotPasswordToken token);

    
    
}
