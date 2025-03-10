package com.zosh.treading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.treading.entity.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {

    PaymentDetails findByUserId(Long userId);
}
