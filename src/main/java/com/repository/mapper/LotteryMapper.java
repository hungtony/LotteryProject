package com.repository.mapper;

import com.pojo.dto.BetResultResponse;
import com.pojo.entity.DrawResult;
import com.pojo.entity.LotteryOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface LotteryMapper {

    void insertBetLottery(LotteryOrder lotteryOrder);
    void checkBetLottery(LotteryOrder lotteryOrder);
    void updateRedeem(Integer id);
    void insertDrawResult(DrawResult result);
    void updateDrawResult(DrawResult result);
    List<BetResultResponse> showLotteryOrderNotRedeem(Integer userId);
    List<LotteryOrder> findLotteryOrderNotRedeem(Integer userId);

}
