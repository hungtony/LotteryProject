package com.service.impl;

import com.pojo.entity.UserInfo;
import com.pojo.dto.UserInfoRequest;
import com.pojo.dto.UserInfoResponse;
import com.repository.UserInfoRepository;
import com.repository.mapper.UserInfoMapper;
import com.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoRepository userInfoRepository;
    @Resource
    UserInfoMapper userInfoMapper;

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



}
