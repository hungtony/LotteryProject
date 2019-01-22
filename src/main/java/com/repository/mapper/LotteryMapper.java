package com.repository.mapper;

import com.pojo.dto.BetLottery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LotteryMapper {

    void insertBetLottery(BetLottery bet);
}
