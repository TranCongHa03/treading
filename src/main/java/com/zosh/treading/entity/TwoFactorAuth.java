package com.zosh.treading.entity;

import com.zosh.treading.domain.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {

    private boolean isEnable = false;
    private VerificationType sendTo;
}
