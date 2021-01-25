package com.imooc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.entity.SellerInfo;

public interface SellerInfoMapper extends BaseMapper<SellerInfo> {
    SellerInfo findByOpenid(Integer openId);
}
