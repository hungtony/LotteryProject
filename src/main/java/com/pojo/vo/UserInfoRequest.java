package com.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoRequest {

    private String account;
    private String password;
    private String realName;
    private String city;
    private String district;
    private String address;
    private String phoneNum;
    private String url;

}
