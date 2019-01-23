package com.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponse {

    private String account;
    private String realName;
    private String city;
    private String district;
    private String address;
    private String phoneNum;
    private String url;

}
