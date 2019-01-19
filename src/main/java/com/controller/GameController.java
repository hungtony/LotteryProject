package com.controller;

import com.pojo.dto.BetLottery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/game")
public class GameController {

    //投注
    @GetMapping(value = "/getBetLottery")
    public List<BetLottery> getBetLottery(Long userId){

        BetLottery betLottery = new BetLottery();

        System.out.println("11223344");
        return null;
    }
    //開獎

    //開獎紀錄

    //歷次紀錄分析

}
