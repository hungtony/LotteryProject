package com.controller;

import com.pojo.entity.DrawResult;
import com.pojo.entity.LotteryOrder;
import com.pojo.dto.BetLotteryRequest;
import com.service.LotteryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
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
    public Boolean betLottery(@RequestBody BetLotteryRequest request){

        List<Integer> lotteryIds = Arrays.asList(1,2,3,4);

        if(!lotteryIds.contains(request.getLotteryId())){
            log.error("Lottery Id not exist!");
            return false;
        }

        return lotteryService.insertBetLottery(request);
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
    @GetMapping(value = "/getBetLotteryByUserId")
    @ResponseBody
    public List<LotteryOrder> getBetLottery(@RequestParam Integer userId,@RequestParam Integer count){

        List<LotteryOrder> lotteryOrderList = lotteryService.getLotteryOrder(userId,count);

        return lotteryOrderList;
    }


    //查詢開獎紀錄
    @ApiOperation(value = "查詢某彩券開獎記錄",notes = "Test")
    @GetMapping(value = "/getLotteryDraw")
    @ResponseBody
    public List<DrawResult> getLotteryDraw(@RequestParam Integer lotteryId, @RequestParam Integer count){

        List<DrawResult> drawResultList = lotteryService.getDrawResult(lotteryId,count);

        return drawResultList;
    }

    //歷次紀錄分析

}
