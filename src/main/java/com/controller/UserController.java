package com.controller;

import com.pojo.dto.BetResultResponse;
import com.pojo.dto.UserInfoResponse;
import com.pojo.dto.UserInfoRequest;
import com.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Api(value = "/userApi")
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    UserInfoService userInfoService;

    @ApiOperation(value = "根據帳號取得使用者資料",notes = "Test")
    @GetMapping(value = "/getUserByAccount")
    @ResponseBody
    public UserInfoResponse getUserByAccount(@RequestParam String account){

        UserInfoResponse response = userInfoService.getUserInfoByAccount(account);
        return response;
    }

    @ApiOperation(value = "根據ID取得使用者資料",notes = "Test")
    @GetMapping(value = "/getUserById")
    @ResponseBody
    public UserInfoResponse getUserById(@RequestParam Integer id){

        UserInfoResponse response = userInfoService.getUserInfoById(id);
        return response;
    }

    @ApiOperation(value = "根據地區取得使用者資料",notes = "Test")
    @GetMapping(value = "/getUserByCity")
    @ResponseBody
    public List<UserInfoResponse> getUserByCity(@RequestParam String city){

        List<UserInfoResponse> responseList = userInfoService.getUserInfoByCity(city);

        return responseList;
    }

    @ApiOperation(value = "新增使用者資料",notes = "Test")
    @PostMapping(value = "/insertUser")
    @ResponseBody
    public void insertUser(@RequestBody UserInfoRequest request){

        userInfoService.insertUserInfo(request);
    }

    @ApiOperation(value = "更新使用者資料",notes = "Test")
    @PostMapping(value = "/updateUser")
    @ResponseBody
    public void updateUser(@RequestBody UserInfoRequest request){

        userInfoService.updateUserInfo(request);
    }

    @ApiOperation(value = "刪除使用者資料",notes = "Test")
    @PostMapping(value = "/deleteUser")
    @ResponseBody
    public void deleteUser(@RequestParam String account){

        userInfoService.deleteUserInfo(account);
    }

    @ApiOperation(value = "兌獎",notes = "Test")
    @PostMapping(value = "/redeemLottery")
    @ResponseBody
    public void redeemLottery(@RequestParam Integer userId){

        userInfoService.redeemLottery(userId);
    }

    @ApiOperation(value = "查看未兌換獎項",notes = "Test")
    @PostMapping(value = "checkNotRedeemLottery")
    @ResponseBody
    public List<BetResultResponse> checkNotRedeemLottery(@RequestParam Integer userId){

        return userInfoService.getNotRedeemList(userId);
    }



}
