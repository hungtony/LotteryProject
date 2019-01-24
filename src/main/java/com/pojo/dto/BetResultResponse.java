package com.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BetResultResponse {

    private Integer userId;
    private Integer lotteryId;
    private String issueCode;
    private Integer multiple;
    private String betNumber;
    private String drawNumbers;
    private LocalDateTime saleTime;
    private LocalDateTime openDrawTime;
    private Integer result;

}
