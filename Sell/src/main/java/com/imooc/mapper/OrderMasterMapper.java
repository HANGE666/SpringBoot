package com.imooc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderMasterMapper extends BaseMapper<OrderMaster> {
    Page<OrderMaster> findByBuyerOpenId(Integer buyerOpenId, Pageable pageable);
}
