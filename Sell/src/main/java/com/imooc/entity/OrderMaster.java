package com.imooc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderMaster {
    /** 订单id. */
    @TableId
    private Integer orderId;
    /** 买家名字. */
    private String buyerName;
    /** 买家手机号. */
    private String buyerPhone;
    /** 买家地址. */
    private String buyerAddress;
    /** 买家微信Openid. */
    private Integer buyerOpenId;
    /** 订单总金额. */
    private BigDecimal orderAmount;
    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /** 支付状态, 默认为0未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /** 创建时间. */
    private Date createTime;
    /** 更新时间. */
    private Date updateTime;

}
