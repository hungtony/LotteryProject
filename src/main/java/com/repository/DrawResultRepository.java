package com.repository;

import com.pojo.entity.DrawResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrawResultRepository extends JpaRepository<DrawResult,Integer> {

    DrawResult findTopByLotteryIdOrderByIssueCodeDesc(Integer lotteryId);

    List<DrawResult> findByLotteryIdOrderByIssueCodeDesc(Integer lotteryId, Pageable pageable);

}
