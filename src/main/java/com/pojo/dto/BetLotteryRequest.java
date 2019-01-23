package com.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BetLotteryRequest {

    private Integer lotteryId;
    private Integer userId;
    private Long multiple;
    private String betNumber;

}
