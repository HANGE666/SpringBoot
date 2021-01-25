package com.imooc.dto;

import lombok.Data;

/**
 * 购物车
 * Created by 廖师兄
 * 2017-06-11 19:37
 */
@Data
public class CartDto {
    /** 商品Id. */
    private Integer productId;
    /** 数量. */
    private Integer productQuantity;
    public CartDto(Integer productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
