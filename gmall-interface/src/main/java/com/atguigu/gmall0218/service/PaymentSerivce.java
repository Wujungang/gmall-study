package com.atguigu.gmall0218.service;

import com.atguigu.gmall.bean.PaymentInfo;

public interface PaymentSerivce {

    /**
     * 保存交易记录
     * @param paymentInfo
     */
    void savePaymentInfo(PaymentInfo paymentInfo);

    /**
     * 根据out_trade_no 查询
     * @param paymentInfoQuery
     * @return
     */
    PaymentInfo getPaymentInfo(PaymentInfo paymentInfoQuery);

    /**
     *
     * @param out_trade_no
     * @param paymentInfo
     */
    void updatePaymentInfo(String out_trade_no, PaymentInfo paymentInfo);

    /**
     * 退款接口
     * @param orderId
     * @return
     */
    boolean refund(String orderId);
}
