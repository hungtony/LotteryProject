package com.repository.mapper;

import com.pojo.entity.UserInfo;
import com.pojo.dto.UserInfoRequest;
import com.pojo.dto.UserInfoResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    UserInfoResponse findUserByAccount(String account);
    List<UserInfoResponse> findUserByCity(String city);
    UserInfoResponse findUserById(Integer id);
    void insertUserInfo(UserInfo userInfo);
    void deleteUserInfo(String account);
    void updateUserInfo(UserInfoRequest request);
    Long findMoneyByUserId(Integer userId);
    void updateMoneyByUserId(@Param("userId")Integer userId, @Param("money") Long money);
}
