package com.service;

import com.pojo.vo.UserInfoRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ServiceTest {

    @Resource
    private UserInfoService userInfoService;

    //@Rollback(false)
    @Test
    public void TestInsert(){

        UserInfoRequest request;

        for(int i = 0; i<10; i++){

            request = new UserInfoRequest().builder()
                    .account("goose"+i)
                    .city("桃園市")
                    .district("中央區")
                    .address("半屏路"+i+"號")
                    .realName("機器人"+i+"號")
                    .password("11111111")
                    .url("www.fb.com")
                    .phoneNum("0982313444")
                    .build();

        userInfoService.insertUserInfo(request);
        }
    }
}
