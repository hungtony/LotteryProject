package com.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BetLotteryRequest {

    private Integer lotteryId;
    private Integer userId;
    private Long multiple;
    private String betNumber;

}
