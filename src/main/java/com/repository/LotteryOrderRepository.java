package com.repository;

import com.pojo.entity.LotteryOrder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotteryOrderRepository extends JpaRepository<LotteryOrder,Integer> {

    List<LotteryOrder> findByUserIdOrderByOrderTimeDesc(Integer userId, Pageable pageable);
    List<LotteryOrder> findByIssueCode(String issueCode);
}
