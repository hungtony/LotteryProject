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
@Table(name = "USER_INFO")
public class UserInfo {

    @Id
    private Integer id;
    private String account;
    private String password;
    private String realName;
    private String city;
    private String district;
    private String address;
    private String phoneNum;
    private String url;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}
