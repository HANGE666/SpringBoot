package com.imooc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.utils.EnumUtil;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * Created by 廖师兄
 * 2017-05-09 11:30
 */
@Data
public class ProductInfo {
    @TableId
    private Integer productId;
    /** 名字. */
    private Integer productName;
    /** 单价. */
    private BigDecimal productPrice;
    /** 库存. */
    private Integer productStock;
    /** 描述. */
    private String productDescription;
    /** 小图. */
    private String productIcon;
    /** 状态, 0正常1下架. */
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    /** 类目编号. */
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
