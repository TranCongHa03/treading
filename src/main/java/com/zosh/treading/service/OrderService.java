package com.zosh.treading.service;

import java.util.List;

import com.zosh.treading.domain.OrderType;
import com.zosh.treading.entity.Coin;
import com.zosh.treading.entity.Order;
import com.zosh.treading.entity.OrderItem;
import com.zosh.treading.entity.User;

public interface OrderService {

    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId) throws Exception;

    List<Order> getAllOrdersOfUser(Long userId,OrderType orderType, String assetSymbol);

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user);
}
