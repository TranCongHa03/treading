package com.zosh.treading.service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.zosh.treading.domain.PaymentMethod;
import com.zosh.treading.entity.PaymentOrder;
import com.zosh.treading.entity.User;
import com.zosh.treading.response.PaymentResponse;

public interface PaymentService {

    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    Boolean ProccedPaymentOrder(PaymentOrder paymentOrder, String paymentId) throws Exception;

    PaymentResponse createRazorpayPaymentLing(User user, Long amount) throws RazorpayException;

    PaymentResponse createStripePaymentLing(User user, Long amount, Long orderId) throws StripeException;
}
