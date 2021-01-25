package com.imooc.service;

import com.imooc.entity.ProductInfo;
import com.imooc.dto.CartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 * Created by 廖师兄
 * 2017-05-09 17:27
 */
public interface ProductService {
    ProductInfo findOne(Integer productId);
    //查询所有在架商品列表
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    String save(ProductInfo productInfo);
    //加库存
    void increaseStock(List<CartDto> cartDtoList);
    //减库存
    void decreaseStock(List<CartDto> cartDtoList);
    //上架
    String onSale(Integer productId);
    //下架
    String offSale(Integer productId);
}
