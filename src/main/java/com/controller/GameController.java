package com.controller;

import com.pojo.entity.LotteryOrder;
import com.pojo.dto.BetLotteryRequest;
import com.service.LotteryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @ApiOperation(value = "開獎",notes = "Test")
    @GetMapping(value = "/openDraw")
    @ResponseBody
    public Boolean openDraw(@RequestParam Integer lotteryId){

        return  lotteryService.openDraw(lotteryId);
    }

    //查詢投注記錄
    @ApiOperation(value = "查詢投注記錄",notes = "Test")
    @GetMapping(value = "/getBetLottery")
    @ResponseBody
    public List<LotteryOrder> getBetLottery(@RequestParam Integer id){

        List<LotteryOrder> lotteryOrderList = lotteryService.getLotteryOrder(id);

        return lotteryOrderList;
    }

    //歷次紀錄分析

}
