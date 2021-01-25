package com.imooc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.entity.ProductCategory;
import com.imooc.mapper.ProductCategoryMapper;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 * Created by 廖师兄
 * 2017-05-09 10:16
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id",categoryId);
        return productCategoryMapper.selectOne(queryWrapper);
    }

    @Override
    public List<ProductCategory> findAll() {
        QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<>();
        return productCategoryMapper.selectList(queryWrapper);
    }

    @Override
    public List<ProductCategory> findByCategoryTypeId(List<Integer> categoryTypeList) {
        return productCategoryMapper.findByCategoryTypeId(categoryTypeList);
    }

    @Override
    public String save(ProductCategory productCategory) {
        productCategoryMapper.insert(productCategory);
        return "成功保存";
    }
}
