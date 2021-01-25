package com.imooc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.entity.OrderDetail;

import java.util.List;

public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
    List<OrderDetail> findByOrderId(Integer orderId);
}
