package com.repository;

import com.pojo.entity.DrawResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrawResultRepository extends JpaRepository<DrawResult,Integer> {

    DrawResult findTopByLotteryIdOrderBySaleTimeDesc(Integer lotteryId);

}
