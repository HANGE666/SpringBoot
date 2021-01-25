package com.imooc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    List<ProductCategory> findByCategoryTypeId(List<Integer> categoryTypeList);
}
