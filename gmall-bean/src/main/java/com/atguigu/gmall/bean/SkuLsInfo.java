package com.atguigu.gmall.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class SkuLsInfo implements Serializable {

    // 不加注解是因为不是数据库的表
    String id;

    BigDecimal price;

    String skuName;

    String catalog3Id;

    String skuDefaultImg;

    // 自定义一个字段来保存热度评分
    Long hotScore=0L;

    List<SkuLsAttrValue> skuAttrValueList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public String getSkuDefaultImg() {
        return skuDefaultImg;
    }

    public void setSkuDefaultImg(String skuDefaultImg) {
        this.skuDefaultImg = skuDefaultImg;
    }

    public Long getHotScore() {
        return hotScore;
    }

    public void setHotScore(Long hotScore) {
        this.hotScore = hotScore;
    }

    public List<SkuLsAttrValue> getSkuAttrValueList() {
        return skuAttrValueList;
    }

    public void setSkuAttrValueList(List<SkuLsAttrValue> skuAttrValueList) {
        this.skuAttrValueList = skuAttrValueList;
    }

    @Override
    public String toString() {
        return "SkuLsInfo{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", skuName='" + skuName + '\'' +
                ", catalog3Id='" + catalog3Id + '\'' +
                ", skuDefaultImg='" + skuDefaultImg + '\'' +
                ", hotScore=" + hotScore +
                ", skuAttrValueList=" + skuAttrValueList +
                '}';
    }
}
