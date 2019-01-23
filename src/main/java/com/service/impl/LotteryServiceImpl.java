package com.service.impl;

import com.pojo.entity.DrawResult;
import com.pojo.entity.LotteryOrder;
import com.pojo.dto.BetLotteryRequest;
import com.repository.DrawResultRepository;
import com.repository.LotteryOrderRepository;
import com.repository.mapper.LotteryMapper;
import com.service.LotteryService;
import com.util.LotteryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
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
    public Boolean openDraw(Integer lotteryId) {

        /**開獎,將結果寫入當期欄位**/
        Optional<DrawResult> drawResult = Optional.ofNullable(drawResultRepository.findTopByLotteryIdOrderBySaleTimeDesc(lotteryId));

        if(!drawResult.isPresent()){
            log.error("No drawResult found, please check SQL statement.");
            return false;
        } //沒撈到就返回

        drawResult.get().setDrawNumbers(LotteryUtils.generateNumbers());
        drawResult.get().setOpenDrawTime(LocalDateTime.now());

        lotteryMapper.updateDrawResult(drawResult.get());
        log.info("Open draw success!");

        /**對獎**/

        /**產生下一期期號**/

        String today = LocalDate.now().toString().replace("-","");

        String issueCode = drawResult.get().getIssueCode();
        String nextIssueCode;

        if(!issueCode.contains(today)){
            nextIssueCode = today + lotteryId + "001";
        }
        else {
            nextIssueCode = String.valueOf(Long.valueOf(issueCode)+1);
        }

        DrawResult nextDrawResult = new DrawResult().builder()
                .lotteryId(lotteryId)
                .saleTime(LocalDateTime.now())
                .issueCode(nextIssueCode)
                .build();
        lotteryMapper.insertDrawResult(nextDrawResult);

        return true;
    }
}
