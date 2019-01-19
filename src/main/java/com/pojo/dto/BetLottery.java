package com.pojo.dto;

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
public class BetLottery {

    @Id
    private Integer id;
    private Integer lotteryId;
    private Long issueCode;
    private Integer userId;
    private Long multiple;
    private String BetNumbers;
    private LocalDateTime orderTime;
    private boolean result;

}
