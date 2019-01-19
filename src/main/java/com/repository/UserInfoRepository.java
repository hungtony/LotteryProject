package com.repository;

import com.pojo.dto.UserInfo;
import com.pojo.vo.UserInfoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    UserInfo findAllById(Integer id);
    UserInfo findByAccount(String account);
    List<UserInfo> findAllByCity(String city);

}
