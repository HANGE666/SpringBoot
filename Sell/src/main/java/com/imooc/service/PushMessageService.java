package com.imooc.service;

import com.imooc.dto.OrderDto;

/**
 * 推送消息
 * Created by 廖师兄
 * 2017-07-30 22:08
 */
public interface PushMessageService {
    //订单状态变更消息
    void orderStatus(OrderDto orderDto);
}
