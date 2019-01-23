package com.service;

import com.pojo.entity.LotteryOrder;
import com.pojo.dto.BetLotteryRequest;

import java.util.List;

public interface LotteryService {

    void insertBetLottery(BetLotteryRequest request);
    List<LotteryOrder> getLotteryOrder(Integer id);
    Boolean openDraw(Integer lotteryId);
}
