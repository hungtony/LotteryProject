package com.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BetLottery {

    @Id
    private Integer id;
    private String lotteryId;
    private String issueCode;
    private Integer userId;
    private Long multiple;
    private String betNumbers;
    private LocalDateTime orderTime;
    private Integer result;

}
