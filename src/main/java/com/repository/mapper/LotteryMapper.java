package com.repository.mapper;

import com.pojo.entity.DrawResult;
import com.pojo.entity.LotteryOrder;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LotteryMapper {

    void insertBetLottery(LotteryOrder lotteryOrder);
    void checkBetLottery(LotteryOrder lotteryOrder);
    void insertDrawResult(DrawResult result);
    void updateDrawResult(DrawResult result);
}
