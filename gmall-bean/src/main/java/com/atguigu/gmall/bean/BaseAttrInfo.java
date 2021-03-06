package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class BaseAttrInfo implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 获取主键自增！
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;

    // baseAttrValue 的集合
    @Transient // 表示当前字段不是表中的字段，是业务需要使用的！
    private List<BaseAttrValue> attrValueList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public List<BaseAttrValue> getAttrValueList() {
        return attrValueList;
    }

    public void setAttrValueList(List<BaseAttrValue> attrValueList) {
        this.attrValueList = attrValueList;
    }

    @Override
    public String toString() {
        return "BaseAttrInfo{" +
                "id='" + id + '\'' +
                ", attrName='" + attrName + '\'' +
                ", catalog3Id='" + catalog3Id + '\'' +
                ", attrValueList=" + attrValueList +
                '}';
    }
}
