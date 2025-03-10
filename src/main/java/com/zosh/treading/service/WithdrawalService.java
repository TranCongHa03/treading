package com.zosh.treading.service;

import java.util.List;

import com.zosh.treading.entity.User;
import com.zosh.treading.entity.Withdrawal;

public interface WithdrawalService {

    Withdrawal requestyWithdrawal(Long amount, User user);

    Withdrawal proceWithwithdrawal(Long withdrawalId, boolean accept) throws Exception;

    List<Withdrawal> getUsersWithdrawalHistory(User user);

    List<Withdrawal> getAllWithdrawalRequest();
}
