package com.imooc.service;

import com.imooc.entity.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by 廖师兄
 * 2017-05-09 10:12
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeId(List<Integer> categoryTypeList);
    String save(ProductCategory productCategory);
}
