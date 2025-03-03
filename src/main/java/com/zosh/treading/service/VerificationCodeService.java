package com.zosh.treading.service;

import com.zosh.treading.domain.VerificationType;
import com.zosh.treading.entity.User;
import com.zosh.treading.entity.VerificationCode;

public interface VerificationCodeService {

    VerificationCode sendVerificationCode(User user, VerificationType verificationType);

    VerificationCode getVerificationCodeById(Long id) throws Exception;

    VerificationCode getVerificationCodeByUser(Long userId);

    void deleteVerificationCodeById(VerificationCode verificationCode);
}
