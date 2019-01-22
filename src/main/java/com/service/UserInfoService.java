package com.service;

import com.pojo.dto.BetLottery;
import com.pojo.dto.UserInfo;
import com.pojo.vo.BetLotteryRequest;
import com.pojo.vo.UserInfoResponse;
import com.pojo.vo.UserInfoRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserInfoService {

    UserInfoResponse getUserInfoByAccount(String account);
    UserInfoResponse getUserInfoById(Integer id);
    List<UserInfoResponse> getUserInfoByCity(String city);
    void insertUserInfo(UserInfoRequest request);
    void updateUserInfo(UserInfoRequest request);
    void deleteUserInfo(String account);

}
