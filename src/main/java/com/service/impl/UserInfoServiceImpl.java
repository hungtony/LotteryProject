package com.service.impl;

import com.pojo.dto.BetResultResponse;
import com.pojo.entity.LotteryOrder;
import com.pojo.entity.UserInfo;
import com.pojo.dto.UserInfoRequest;
import com.pojo.dto.UserInfoResponse;
import com.repository.UserInfoRepository;
import com.repository.mapper.LotteryMapper;
import com.repository.mapper.UserInfoMapper;
import com.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoRepository userInfoRepository;
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    LotteryMapper lotteryMapper;

    @Override
    public UserInfoResponse getUserInfoByAccount(String account) {

        return userInfoMapper.findUserByAccount(account);
    }

    @Override
    public UserInfoResponse getUserInfoById(Integer id) {

        return userInfoMapper.findUserById(id);
    }

    @Override
    public List<UserInfoResponse> getUserInfoByCity(String city) {

        return userInfoMapper.findUserByCity(city);
    }

    @Override
    public void insertUserInfo(UserInfoRequest request) {

        UserInfo userInfo = new UserInfo().builder()
                .account(request.getAccount())
                .password(request.getPassword())
                .realName(request.getRealName())
                .city(request.getCity())
                .district(request.getDistrict())
                .address(request.getAddress())
                .phoneNum(request.getPhoneNum())
                .url(request.getUrl())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .status(1)
                .money(100L)
                .build();

        userInfoMapper.insertUserInfo(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfoRequest request) {

        userInfoMapper.updateUserInfo(request);
    }

    @Override
    public void deleteUserInfo(String account) {

        userInfoMapper.deleteUserInfo(account);
    }

    @Override
    public void redeemLottery(Integer userId) {

        List<BetResultResponse> betResultList = lotteryMapper.findLotteryOrderNotRedeem(userId);

        Long winMoney = betResultList.stream().map(b->{

            switch (b.getResult()){
                case 1: return b.getMultiple()*10000000;
                case 2: return b.getMultiple()*2000000;
                case 3: return b.getMultiple()*100000;
                case 4: return b.getMultiple()*20000;
                case 5: return b.getMultiple()*4000;
                case 6: return b.getMultiple()*2000;
                case 7: return b.getMultiple()*800;
                case 8: return b.getMultiple()*500;

                default:return 0;
            }
        }).collect(Collectors.summingLong(Integer::longValue));

        //TODO:redeem set true;


        //TODO:需要取出金額計算完後再放入
        userInfoMapper.updateMoneyByUserId(userId,winMoney);
    }

    @Override
    public List<BetResultResponse> getBetResultList(Integer userId) {

        return lotteryMapper.findLotteryOrderNotRedeem(userId);
    }
}
