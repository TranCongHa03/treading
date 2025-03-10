package com.zosh.treading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.treading.entity.Withdrawal;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
    
    List<Withdrawal> findByUserId(Long userId);



}
