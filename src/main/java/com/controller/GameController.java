package com.controller;

import com.pojo.dto.BetLottery;
import com.pojo.vo.BetLotteryRequest;
import com.service.LotteryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "gameApi")
@Controller
@RequestMapping(value = "/game")
public class GameController {

    @Resource
    LotteryService lotteryService;

    //投注
    @ApiOperation(value = "投注",notes = "Test")
    @PostMapping(value = "/bet")
    @ResponseBody
    public void betLottery(@RequestBody BetLotteryRequest request){

        lotteryService.insertBetLottery(request);
    }

    //開獎

    //查詢投注記錄

    @GetMapping(value = "/getBetLottery")
    public List<BetLottery> getBetLottery(Integer id){

        List<BetLottery> betLotteryList = lotteryService.getBetLottery(id);

        return betLotteryList;
    }

    //歷次紀錄分析

}
