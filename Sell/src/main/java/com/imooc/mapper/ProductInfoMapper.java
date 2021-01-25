package com.imooc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.entity.ProductInfo;

import java.util.List;

public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
