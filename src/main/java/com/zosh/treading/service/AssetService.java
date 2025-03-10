package com.zosh.treading.service;

import java.util.List;

import com.zosh.treading.entity.Asset;
import com.zosh.treading.entity.Coin;
import com.zosh.treading.entity.User;

public interface AssetService  {

    Asset createAsset(User user, Coin coin, double quantity);

    Asset getAssetById(Long assetId);

    Asset getAssetByUserIdAndId(Long userId, Long assetId);

    List<Asset> getUsersAssets(Long userId);

    Asset updAsset(Long assetId, double quantity);

    Asset findAssetByUserIdAndCoinId(Long userId, String coinId);

    void deleteAsset(Long assetId);
}
