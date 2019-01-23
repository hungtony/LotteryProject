package com.pojo.entity;

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
@Table(name = "DRAW_RESULT")
public class DrawResult {

    @Id
    private Integer id;
    private Integer lotteryId;
    private String issueCode;
    private String drawNumbers;
    private LocalDateTime saleTime;
    private LocalDateTime openDrawTime;

}
