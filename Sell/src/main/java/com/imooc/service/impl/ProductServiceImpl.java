package com.imooc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.entity.ProductInfo;
import com.imooc.dto.CartDto;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.mapper.ProductInfoMapper;
import com.imooc.productInfoMapper.ProductInfoProductInfoMapper;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-05-09 17:31
 */
@Service
public class ProductServiceImpl implements ProductService {

    /*
    QueryWrapper<WycTLycxOrderDetail> wrapper = new QueryWrapper();
        wrapper.eq("order_id", orderInfo.getId());
        WycTLycxOrderDetail wycTLycxOrderDetail = orderDetailMapper.selectOne(wrapper);
     */

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public ProductInfo findOne(Integer productId) {
        QueryWrapper<ProductInfo> productInfoQueryWrapper = new QueryWrapper<>();
        productInfoQueryWrapper.eq("product_id",productId);
        return productInfoMapper.selectOne(productInfoQueryWrapper);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoMapper.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoMapper.findAll(pageable);
    }

    @Override
    public String save(ProductInfo productInfo) {
        productInfoMapper.insert(productInfo);
        return "成功保存";
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDto> cartDtoList) {
        for (CartDto cartDto: cartDtoList) {
            QueryWrapper<ProductInfo> productInfoQueryWrapper = new QueryWrapper<>();
            productInfoQueryWrapper.eq("product_id",cartDto.getProductId());
            ProductInfo productInfo = productInfoMapper.selectOne(productInfoQueryWrapper);
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDto.getProductQuantity();
            productInfo.setProductStock(result);

            productInfoMapper.insert(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtoList) {
        for (CartDto cartDTO: cartDtoList) {
            QueryWrapper<ProductInfo> productInfoQueryWrapper = new QueryWrapper<>();
            productInfoQueryWrapper.eq("product_id",cartDTO.getProductId());
            ProductInfo productInfo = productInfoMapper.selectOne(productInfoQueryWrapper);
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoMapper.insert(productInfo);
        }
    }

    @Override
    public String onSale(Integer productId) {
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id",productId);
        ProductInfo productInfo = productInfoMapper.selectOne(queryWrapper);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfoMapper.insert(productInfo);
        return "成功上架";
    }

    @Override
    public String offSale(Integer productId) {
        QueryWrapper<ProductInfo> productInfoQueryWrapper = new QueryWrapper<>();
        productInfoQueryWrapper.eq("product_id",productId);
        ProductInfo productInfo = productInfoMapper.selectOne(productInfoQueryWrapper);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfoMapper.insert(productInfo);
        return "成功下架";
    }
}
