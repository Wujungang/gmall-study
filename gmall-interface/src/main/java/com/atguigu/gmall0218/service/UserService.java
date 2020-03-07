package com.atguigu.gmall0218.service;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> findAll();

    List<UserAddress> getUserAddressList(String userId);


    /**
     * 登录方法
     * @param userInfo
     * @return
     */
    UserInfo login(UserInfo userInfo);

    /**
     * 根据用户Id 查询数据
     * @param userId
     * @return
     */
    UserInfo verify(String userId);
}
