package com.controller;

import com.pojo.dto.BetLottery;
import com.pojo.vo.BetLotteryRequest;
import com.service.LotteryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/game")
public class GameController {

    @Resource
    LotteryService lotteryService;

    //投注
    @PostMapping(value = "/bet")
    public void betLottery(BetLotteryRequest request){

        lotteryService.insertBetLottery(request);
    }

    //開獎

    //查詢中獎狀況
    @GetMapping(value = "/getBetLottery")
    public List<BetLottery> getBetLottery(Long userId){

        BetLottery betLottery = new BetLottery();

        System.out.println("11223344");
        return null;
    }

    //歷次紀錄分析

}
