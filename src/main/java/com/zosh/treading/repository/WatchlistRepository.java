package com.zosh.treading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.treading.entity.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    Watchlist findByUserId(Long userId);

}
