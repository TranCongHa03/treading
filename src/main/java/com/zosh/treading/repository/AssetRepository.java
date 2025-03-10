package com.zosh.treading.repository;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.treading.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    List<Asset> findByUserId(Long userId);

    Asset findByUserIdAndCoinId(Long userId, String coinId);

    
}
