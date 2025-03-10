package com.zosh.treading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.treading.domain.OrderType;
import com.zosh.treading.entity.Coin;
import com.zosh.treading.entity.Order;
import com.zosh.treading.entity.User;
import com.zosh.treading.entity.WalletTransaction;
import com.zosh.treading.request.CreateOrderRequest;
import com.zosh.treading.service.CoinService;
import com.zosh.treading.service.OrderService;
import com.zosh.treading.service.UserService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;

    // @Autowired
    // private WalletTransactionService walletTransactionService;

    @PostMapping("/pay")
    public ResponseEntity<Order> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateOrderRequest req) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Coin coin = coinService.findById(req.getCoinId());

        Order order = orderService.processOrder(coin, req.getQuantity(), req.getOrderType(), user);

        return ResponseEntity.ok(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(
            @RequestHeader("Authorization") String jwtToken,
            @PathVariable Long orderId) throws Exception {
       
    
            User user = userService.findUserProfileByJwt(jwtToken);

            Order order = orderService.getOrderById(orderId);
            if(order.getUser().getId().equals(user.getId())){
                return ResponseEntity.ok(order);
            }else{
               throw new Exception("you don't have access");
            }
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrdersForUser(
        @RequestHeader("Authorization") String jwt,
        @RequestParam (required = false) OrderType order_type,
        @RequestParam(required = false) String asset_symbol
    ) throws Exception{

        Long userId = userService.findUserProfileByJwt(jwt).getId();

        List<Order> userOrders = orderService.getAllOrdersOfUser(userId, order_type, asset_symbol);

        return ResponseEntity.ok(userOrders);
    }
}
