package com.zosh.treading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.treading.entity.Coin;

public interface CoinRepository extends JpaRepository<Coin, String> {

}
