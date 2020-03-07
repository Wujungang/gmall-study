package com.atguigu.gmall0218.service;


import com.atguigu.gmall.bean.*;

import java.util.List;

public interface ListService {

    void saveSkuLsInfo(SkuLsInfo skuLsInfo);

    SkuLsResult search(SkuLsParams skuLsParams);

    void incrHotScore(String skuId);
}
