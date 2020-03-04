package com.atguigu.gmall.list.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.bean.SkuLsParams;
import com.atguigu.gmall.bean.SkuLsResult;
import com.atguigu.gmall0218.service.ListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ListController {

    @Reference
    private ListService listService;

    // http://list.gmall.com/list.html?catalog3Id=61

    @RequestMapping("list.html")
    @ResponseBody
    public String listData(SkuLsParams skuLsParams){
        SkuLsResult skuLsResult = listService.search(skuLsParams);

        return JSON.toJSONString(skuLsResult);
    }

}