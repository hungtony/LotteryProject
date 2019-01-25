package com.service;

import com.pojo.dto.BetLotteryRequest;
import com.pojo.dto.UserInfoRequest;
import com.util.LotteryUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ServiceTest {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    LotteryService lotteryService;


    @Rollback(false)
    @Test
    public void TestInsert(){

        UserInfoRequest request;

        for(int i = 0; i<10; i++){

            request = new UserInfoRequest().builder()
                    .account("amy"+i)
                    .city("桃園市")
                    .district("中央區")
                    .address("半屏路"+i+"號")
                    .realName("機器人"+i+"號")
                    .password("11111111")
                    .url("www.fb.com")
                    .phoneNum("0982313444")
                    .build();

        userInfoService.insertUserInfo(request);
        }
    }

    @Test
    @Rollback(false)
    public void TestBet(){

        for(int i= 0; i<20; i++){

            BetLotteryRequest request = new BetLotteryRequest().builder()
                    .lotteryId(3)
                    .multiple(1l)
                    .userId(3)
                    .betNumber(LotteryUtils.generateNumbers(6))
                    .build();
            lotteryService.insertBetLottery(request);

            //System.out.println(request.getBetNumber());
        }

        for(int i= 0; i<20; i++){

            BetLotteryRequest request = new BetLotteryRequest().builder()
                    .lotteryId(4)
                    .multiple(1l)
                    .userId(4)
                    .betNumber(LotteryUtils.generateNumbers(6))
                    .build();
            lotteryService.insertBetLottery(request);

            //System.out.println(request.getBetNumber());
        }

    }
}
