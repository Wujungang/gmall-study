package com.atguigu.gmall.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class SkuLsAttrValue implements Serializable{

    String valueId;

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    @Override
    public String toString() {
        return "SkuLsAttrValue{" +
                "valueId='" + valueId + '\'' +
                '}';
    }
}
