package com.imooc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetail {
    @TableId
    private Integer detailId;
    /** 订单id. */
    private Integer orderId;
    /** 商品id. */
    private Integer productId;
    /** 商品名称. */
    private String productName;
    /** 商品单价. */
    private BigDecimal productPrice;
    /** 商品数量. */
    private Integer productQuantity;
    /** 商品小图. */
    private String productIcon;
}
