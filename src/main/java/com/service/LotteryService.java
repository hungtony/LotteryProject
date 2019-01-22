package com.service;

import com.pojo.dto.BetLottery;
import com.pojo.vo.BetLotteryRequest;

import java.util.List;

public interface LotteryService {

    void insertBetLottery(BetLotteryRequest request);
    List<BetLottery> getBetLottery(Integer id);
}
