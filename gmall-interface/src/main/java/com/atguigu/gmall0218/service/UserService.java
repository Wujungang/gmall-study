package com.atguigu.gmall0218.service;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> findAll();

    List<UserAddress> getUserAddressList(String userId);
}
