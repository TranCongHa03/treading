package com.zosh.treading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.treading.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet findByUserId(Long userId);
}
