package com.atguigu.gmall0218.service;

import com.atguigu.gmall.bean.*;

import java.util.List;

public interface ManageService {

    List<BaseCatalog1> getCataLog1();

    List<BaseCatalog2> getCataLog2(String catalog1Id);

    List<BaseCatalog3> getCataLog3(String catalog2Id);

    List<BaseAttrInfo> getAttrList(String catalog3Id);

    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    BaseAttrInfo getAttrInfo(String attrId);

    //查询平台spu信息
    List<SpuInfo> getSpuList(SpuInfo spuInfo);

    /**
     * 获取所有的销售属性数据
     * @return
     */
    List<BaseSaleAttr> getBaseSaleAttrList();

    /**
     * 保存spuInfo
     * @param spuInfo
     */
    void saveSpuInfo(SpuInfo spuInfo);

    List<SpuImage> getSpuImageList(SpuImage spuImage);

    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);


    void saveSkuInfo(SkuInfo skuInfo);

    SkuInfo getSkuInfo(String skuId);

    List<SkuImage> getSkuImageBySkuId(String skuId);

    List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(SkuInfo skuInfo);

    List<SkuSaleAttrValue> getSkuSaleAttrValueListBySpu(String spuId);

    /**
     * 根据平台属性值id查询
     * @param attrValueIdList
     * @return
     */
    List<BaseAttrInfo> getAttrList(List<String> attrValueIdList);
}
