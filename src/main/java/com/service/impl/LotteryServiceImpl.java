package com.service.impl;

import com.pojo.dto.DrawResult;
import com.pojo.dto.LotteryOrder;
import com.pojo.vo.BetLotteryRequest;
import com.repository.DrawResultRepository;
import com.repository.LotteryOrderRepository;
import com.repository.mapper.LotteryMapper;
import com.service.LotteryService;
import com.util.LotteryUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LotteryServiceImpl implements LotteryService {

    @Resource
    LotteryMapper lotteryMapper;

    @Resource
    DrawResultRepository drawResultRepository;

    @Resource
    LotteryOrderRepository lotteryOrderRepository;

    @Override
    public void insertBetLottery(BetLotteryRequest request) {

        LotteryOrder bet = new LotteryOrder().builder()
                .issueCode(LocalDate.now().toString().replace("-","")+"001")//待修正
                .lotteryId(request.getLotteryId())
                .betNumber(request.getBetNumber())
                .multiple(request.getMultiple())
                .orderTime(LocalDateTime.now())
                .userId(request.getUserId())
                .result(0)
                .build();

        lotteryMapper.insertBetLottery(bet);
    }

    @Override
    public List<LotteryOrder> getLotteryOrder(Integer id) {

        return lotteryOrderRepository.findByUserId(id);
    }

    @Override
    public void openDraw(Integer lotteryId) {

        String issueCode;
        String today = LocalDate.now().toString().replace("-","");


        Optional<DrawResult> lastDrawResult = Optional
                .ofNullable(drawResultRepository.findTopByLotteryIdOrderBySaleTimeDesc(lotteryId));

        if(!lastDrawResult.isPresent()||!lastDrawResult.get().getIssueCode().contains(today)){
            issueCode = today + lotteryId + "001";
        }
        else {
            issueCode = String.valueOf(Long.valueOf(lastDrawResult.get().getIssueCode())+1);
        }

        DrawResult drawResult = new DrawResult().builder()
                .lotteryId(lotteryId)
                .drawResult(LotteryUtils.generateNumbers())
                .openDrawTime(LocalDateTime.now())
                .saleTime(LocalDateTime.now())
                .issueCode(issueCode)
                .build();

        lotteryMapper.insertDrawResult(drawResult);

    }
}
