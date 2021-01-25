package com.imooc.service;

import com.imooc.dto.OrderDto;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * 支付
 * Created by 廖师兄
 * 2017-07-04 00:53
 */
public interface PayService {
    PayResponse create(OrderDto orderDto);
    PayResponse notify(String notifyData);
    RefundResponse refund(OrderDto orderDto);
}
