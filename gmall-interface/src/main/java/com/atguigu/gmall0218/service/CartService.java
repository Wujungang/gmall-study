package com.atguigu.gmall0218.service;

import com.atguigu.gmall.bean.CartInfo;

import java.util.List;

public interface CartService {

    // 写方法？ skuNum,skuId,userId
    void  addToCart(String skuId,String userId,Integer skuNum);


    /**
     * 根据用户Id 查询购物车数据！
     * @param userId
     * @return
     */
    List<CartInfo> getCartList(String userId);

    /**
     * 合并购物车
     * @param cartListCK
     * @param userId
     * @return
     */
    List<CartInfo> mergeToCartList(List<CartInfo> cartListCK, String userId);
}
