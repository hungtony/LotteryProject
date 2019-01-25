package com.service.impl;

import com.pojo.entity.DrawResult;
import com.pojo.entity.LotteryOrder;
import com.pojo.dto.BetLotteryRequest;
import com.repository.DrawResultRepository;
import com.repository.LotteryOrderRepository;
import com.repository.mapper.LotteryMapper;
import com.repository.mapper.UserInfoMapper;
import com.service.LotteryService;
import com.util.LotteryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    UserInfoMapper userInfoMapper;

    @Resource
    DrawResultRepository drawResultRepository;

    @Resource
    LotteryOrderRepository lotteryOrderRepository;


    /****
     * TODO:null驗證
     */
    @Override
    public Boolean insertBetLottery(BetLotteryRequest request) {

        String issueCode = drawResultRepository.findTopByLotteryIdOrderByIssueCodeDesc(request.getLotteryId()).getIssueCode();


        //確認餘額足夠
        Long userMoney = userInfoMapper.findMoneyByUserId(request.getUserId());

        if(userMoney < request.getMultiple()*100L){
            log.error("Money is not enough!");
            return false;
        }

        //扣錢
        Long payMoney = -request.getMultiple()*100L;
        userInfoMapper.updateMoneyByUserId(request.getUserId(),payMoney);

        //成立投注單
        LotteryOrder bet = new LotteryOrder().builder()
                .issueCode(issueCode)
                .lotteryId(request.getLotteryId())
                .betNumber(request.getBetNumber())
                .multiple(request.getMultiple())
                .orderTime(LocalDateTime.now())
                .userId(request.getUserId())
                .result(0)
                .redeem(false)
                .build();

        lotteryMapper.insertBetLottery(bet);

        return true;
    }

    @Override
    public List<LotteryOrder> getLotteryOrder(Integer userId, Integer count) {

        Pageable pageable = PageRequest.of(0, count);

        return lotteryOrderRepository.findByUserIdOrderByOrderTimeDesc(userId, pageable);
    }

    @Override
    public List<DrawResult> getDrawResult(Integer lotteryId, Integer count) {

        Pageable pageable = PageRequest.of(0, count);

        return drawResultRepository.findByLotteryIdOrderByIssueCodeDesc(lotteryId, pageable);
    }

    @Override
    public Boolean openDraw(Integer lotteryId) {

        /**開獎,將結果寫入當期欄位**/
        Optional<DrawResult> drawResult = Optional.ofNullable(drawResultRepository.findTopByLotteryIdOrderByIssueCodeDesc(lotteryId));

        if(!drawResult.isPresent()){
            log.error("No drawResult found, please check SQL statement.");
            return false;
        } //沒撈到就返回

        drawResult.get().setDrawNumbers(LotteryUtils.generateNumbers(7));
        drawResult.get().setOpenDrawTime(LocalDateTime.now());

        lotteryMapper.updateDrawResult(drawResult.get());
        log.info("Open draw success!");

        /**對獎**/
        List<LotteryOrder> lotteryOrderList = lotteryOrderRepository.findByIssueCode(drawResult.get().getIssueCode());

        lotteryOrderList.forEach(l->{
            l.setResult(LotteryUtils.checkLottery(l.getBetNumber(),drawResult.get().getDrawNumbers()));
            if(l.getResult() == 99) {l.setRedeem(true);}
            lotteryMapper.checkBetLottery(l);
        });


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
