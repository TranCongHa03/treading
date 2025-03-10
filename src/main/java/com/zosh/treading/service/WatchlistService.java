package com.zosh.treading.service;

import com.zosh.treading.entity.Coin;
import com.zosh.treading.entity.User;
import com.zosh.treading.entity.Watchlist;

public interface WatchlistService {

    Watchlist findUserWatchlist(Long userId) throws Exception;

    Watchlist createWatchlist(User user);

    Watchlist findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin, User user) throws Exception;
    
}
