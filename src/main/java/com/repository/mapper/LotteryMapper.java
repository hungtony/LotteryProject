package com.repository.mapper;

import com.pojo.dto.DrawResult;
import com.pojo.dto.LotteryOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LotteryMapper {

    void insertBetLottery(LotteryOrder bet);
    void insertDrawResult(DrawResult result);
}
