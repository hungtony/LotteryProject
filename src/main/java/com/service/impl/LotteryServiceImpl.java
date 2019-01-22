package com.service.impl;

import com.pojo.dto.BetLottery;
import com.pojo.vo.BetLotteryRequest;
import com.repository.LotteryRepository;
import com.repository.mapper.LotteryMapper;
import com.service.LotteryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LotteryServiceImpl implements LotteryService {

    @Resource
    LotteryMapper lotteryMapper;

    @Resource
    LotteryRepository lotteryRepository;

    @Override
    public void insertBetLottery(BetLotteryRequest request) {

        BetLottery bet = new BetLottery().builder()
                .issueCode(LocalDate.now().toString().replace("-",""))
                .lotteryId(request.getLotteryId())
                .betNumbers(request.getBetNumbers())
                .multiple(request.getMultiple())
                .orderTime(LocalDateTime.now())
                .userId(request.getUserId())
                .result(0)
                .build();

        lotteryMapper.insertBetLottery(bet);
    }

    @Override
    public List<BetLottery> getBetLottery(Integer id) {

        return lotteryRepository.findByUserId(id);
    }
}
