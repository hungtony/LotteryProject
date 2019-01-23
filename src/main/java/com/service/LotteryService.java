package com.service;

import com.pojo.dto.LotteryOrder;
import com.pojo.vo.BetLotteryRequest;

import java.util.List;

public interface LotteryService {

    void insertBetLottery(BetLotteryRequest request);
    List<LotteryOrder> getLotteryOrder(Integer id);
    void openDraw(Integer lotteryId);
}
