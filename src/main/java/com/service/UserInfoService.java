package com.service;

import com.pojo.dto.UserInfoResponse;
import com.pojo.dto.UserInfoRequest;

import java.util.List;


public interface UserInfoService {

    UserInfoResponse getUserInfoByAccount(String account);
    UserInfoResponse getUserInfoById(Integer id);
    List<UserInfoResponse> getUserInfoByCity(String city);
    void insertUserInfo(UserInfoRequest request);
    void updateUserInfo(UserInfoRequest request);
    void deleteUserInfo(String account);

}
