package com.atguigu.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.SkuInfo;
import com.atguigu.gmall.bean.SkuLsInfo;
import com.atguigu.gmall.bean.SpuImage;
import com.atguigu.gmall.bean.SpuSaleAttr;
import com.atguigu.gmall0218.service.ListService;
import com.atguigu.gmall0218.service.ManageService;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SkuManageController {


    @Reference
    private ManageService manageService;

    @Reference
    private ListService listService;

    //http://localhost:8082/spuImageList?spuId=58
    @RequestMapping("spuImageList")
    public List<SpuImage> spuImageList(SpuImage spuImage){
        List<SpuImage> spuImageList = manageService.getSpuImageList(spuImage);

        return spuImageList;
    }

    //http://localhost:8082/spuSaleAttrList?spuId=58
    @RequestMapping("spuSaleAttrList")
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){
        // 调用service 层

        return manageService.getSpuSaleAttrList(spuId);
    }

    @RequestMapping("saveSkuInfo")
    public void saveSkuInfo(@RequestBody SkuInfo skuInfo){
        if (skuInfo!=null){
            manageService.saveSkuInfo(skuInfo);
        }
    }

    @RequestMapping("onSale")
    public void onSale(String skuId){
        SkuLsInfo skuLsInfo = new SkuLsInfo();

        SkuInfo skuInfo = manageService.getSkuInfo(skuId);
        System.out.println(skuInfo);
        System.out.println("###########"+skuInfo);
        BeanUtils.copyProperties(skuInfo,skuLsInfo);
        System.out.println("**********"+skuLsInfo);
        listService.saveSkuLsInfo(skuLsInfo);
    }
}
