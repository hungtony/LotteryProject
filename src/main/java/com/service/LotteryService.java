package com.service;

import com.pojo.entity.DrawResult;
import com.pojo.entity.LotteryOrder;
import com.pojo.dto.BetLotteryRequest;

import java.util.List;

public interface LotteryService {

    Boolean insertBetLottery(BetLotteryRequest request);
    List<LotteryOrder> getLotteryOrder(Integer userId, Integer count);
    List<DrawResult> getDrawResult(Integer lotteryId, Integer count);
    Boolean openDraw(Integer lotteryId);
}
