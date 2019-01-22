package com.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BetLotteryRequest {

    private String lotteryId;
    private Integer userId;
    private Long multiple;
    private String betNumbers;

}
