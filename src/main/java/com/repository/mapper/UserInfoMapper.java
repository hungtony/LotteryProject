package com.repository.mapper;

import com.pojo.dto.UserInfo;
import com.pojo.vo.UserInfoRequest;
import com.pojo.vo.UserInfoResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    UserInfoResponse findUserByAccount(String account);
    List<UserInfoResponse> findUserByCity(String city);
    UserInfoResponse findUserById(Integer id);
    void insertUserInfo(UserInfo userInfo);
    void deleteUserInfo(String account);
    void updateUserInfo(UserInfoRequest request);
}
