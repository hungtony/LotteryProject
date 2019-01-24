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
public class LotteryOrderTest {

    @Resource
    LotteryService lotteryService;

    @Test
    @Rollback(false)
    public void TestInsert(){

        for(int i= 0; i<100; i++){

            BetLotteryRequest request = new BetLotteryRequest().builder()
                    .lotteryId(1)
                    .multiple(100l)
                    .userId(1)
                    .betNumber(LotteryUtils.generateNumbers(6))
                    .build();
            lotteryService.insertBetLottery(request);

            System.out.println(request.getBetNumber());
        }

    }


}
