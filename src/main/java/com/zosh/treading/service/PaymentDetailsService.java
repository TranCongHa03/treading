package com.zosh.treading.service;

import com.zosh.treading.entity.PaymentDetails;
import com.zosh.treading.entity.User;

public interface PaymentDetailsService {

    public PaymentDetails addPaymentDetails(String accountNumber,
            String accountHolderName,
            String ifsc,
            String bankName,
            User user);

    public PaymentDetails getUsersPaymentDetails(User user);

}
