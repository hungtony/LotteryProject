package com.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LOTTERY_ORDER")
public class LotteryOrder {

    @Id
    private Integer id;
    private Integer lotteryId;
    private String issueCode;
    private Integer userId;
    private Long multiple;
    private String betNumber;
    private LocalDateTime orderTime;
    private Integer result;

}