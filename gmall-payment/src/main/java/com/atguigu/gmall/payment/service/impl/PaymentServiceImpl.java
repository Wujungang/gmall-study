package com.atguigu.gmall.payment.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.atguigu.gmall.bean.OrderInfo;
import com.atguigu.gmall.bean.PaymentInfo;
import com.atguigu.gmall.payment.mapper.PaymentInfoMapper;
import com.atguigu.gmall0218.service.OrderService;
import com.atguigu.gmall0218.service.PaymentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;

@Service
public class PaymentServiceImpl implements PaymentSerivce {

    @Autowired
    private PaymentInfoMapper paymentInfoMapper;

    @Autowired
    private AlipayClient alipayClient;

    @Reference
    private OrderService orderService;
    @Override
    public void savePaymentInfo(PaymentInfo paymentInfo) {
        paymentInfoMapper.insertSelective(paymentInfo);
    }

    @Override
    public PaymentInfo getPaymentInfo(PaymentInfo paymentInfoQuery) {
        // select * from paymentInfo where out_trade_no =?
      return   paymentInfoMapper.selectOne(paymentInfoQuery);
    }

    @Override
    public void updatePaymentInfo(String out_trade_no, PaymentInfo paymentInfo) {
        // 更新
        Example example = new Example(PaymentInfo.class);
        example.createCriteria().andEqualTo("outTradeNo",out_trade_no);
        paymentInfoMapper.updateByExampleSelective(paymentInfo,example);
    }

    @Override
    public boolean refund(String orderId) {

        // 通过orderId 获取数据
        OrderInfo orderInfo = orderService.getOrderInfo(orderId);
        // AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","GBK","alipay_public_key","RSA2");
        //alipay.trade.refund
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        HashMap<String, Object> map = new HashMap<>();
        map.put("out_trade_no",orderInfo.getOutTradeNo());
        map.put("refund_amount",orderInfo.getTotalAmount());
        map.put("refund_reason","不买了！");

        request.setBizContent(JSON.toJSONString(map));
//        request.setBizContent("{" +
//                "\"out_trade_no\":\"20150320010101001\"," +
//                "\"trade_no\":\"2014112611001004680073956707\"," +
//                "\"refund_amount\":200.12," +
//                "\"refund_currency\":\"USD\"," +
//                "\"refund_reason\":\"正常退款\"," +
//                "\"out_request_no\":\"HZ01RF001\"," +
//                "\"operator_id\":\"OP001\"," +
//                "\"store_id\":\"NJ_S_001\"," +
//                "\"terminal_id\":\"NJ_T_001\"," +
//                "      \"goods_detail\":[{" +
//                "        \"goods_id\":\"apple-01\"," +
//                "\"alipay_goods_id\":\"20010001\"," +
//                "\"goods_name\":\"ipad\"," +
//                "\"quantity\":1," +
//                "\"price\":2000," +
//                "\"goods_category\":\"34543238\"," +
//                "\"categories_tree\":\"124868003|126232002|126252004\"," +
//                "\"body\":\"特价手机\"," +
//                "\"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
//                "        }]," +
//                "      \"refund_royalty_parameters\":[{" +
//                "        \"royalty_type\":\"transfer\"," +
//                "\"trans_out\":\"2088101126765726\"," +
//                "\"trans_out_type\":\"userId\"," +
//                "\"trans_in_type\":\"userId\"," +
//                "\"trans_in\":\"2088101126708402\"," +
//                "\"amount\":0.1," +
//                "\"amount_percentage\":100," +
//                "\"desc\":\"分账给2088101126708402\"" +
//                "        }]," +
//                "\"org_pid\":\"2088101117952222\"" +
//                "  }");
        AlipayTradeRefundResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(response.isSuccess()){
            // 更新状态！
            System.out.println("调用成功");
            return true;

        } else {
            System.out.println("调用失败");
            return false;
        }
    }
}
