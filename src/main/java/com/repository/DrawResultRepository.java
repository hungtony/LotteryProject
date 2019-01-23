package com.repository;

import com.pojo.dto.DrawResult;
import com.pojo.dto.LotteryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrawResultRepository extends JpaRepository<DrawResult,Integer> {

    DrawResult findTopByLotteryIdOrderBySaleTimeDesc(Integer lotteryId);

}
