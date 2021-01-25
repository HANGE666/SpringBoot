package com.imooc.service;

import com.imooc.dto.OrderDto;

/**
 * 买家
 * Created by 廖师兄
 * 2017-06-22 00:11
 */
public interface BuyerService {
    //查询一个订单
    OrderDto findOrderOne(Integer openid, Integer orderId);
    //取消订单
    OrderDto cancelOrder(Integer openid, Integer orderId);
}
