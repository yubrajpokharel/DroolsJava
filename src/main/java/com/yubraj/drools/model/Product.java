package com.yubraj.drools.model;

import com.yubraj.drools.enums.TypeEnum;

/**
 * Created by ypokhrel on 7/25/2017.
 */
public class Product {
    private final TypeEnum typeEnum;
    private String productName;

    public Product(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
        productName = typeEnum.getSomeOutputString();
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
