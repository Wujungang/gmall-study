package com.atguigu.gmall0218.service;

import com.atguigu.gmall.bean.OrderInfo;

public interface OrderService {
    /**
     * 保存订单
     * @param orderInfo
     * @return
     */
    String saveOrder(OrderInfo orderInfo);


    /**
     * 生成流水号
     * @param userId
     * @return
     */
    String getTradeNo(String userId);

    /**
     *
     * @param userId 获取缓存的流水号
     * @param tradeCodeNo 页面的流水号
     * @return
     */
    boolean checkTradeCode(String userId, String tradeCodeNo);

    /**
     * 删除流水号
     * @param userId
     */
    void  delTradeCode(String userId);

    boolean checkStock(String skuId, Integer skuNum);

    /**
     * 根据orderId 查询订单对象
     * @param orderId
     * @return
     */
    OrderInfo getOrderInfo(String orderId);
}
