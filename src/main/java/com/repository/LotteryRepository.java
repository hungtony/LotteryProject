package com.repository;

import com.pojo.dto.BetLottery;
import com.pojo.dto.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotteryRepository extends JpaRepository<UserInfo,Integer> {


    List<BetLottery> findByUserId(Integer id);

}
