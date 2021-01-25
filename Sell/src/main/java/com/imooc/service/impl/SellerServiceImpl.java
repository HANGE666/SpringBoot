package com.imooc.service.impl;

import com.imooc.mapper.SellerInfoMapper;
import com.imooc.entity.SellerInfo;
import com.imooc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 廖师兄
 * 2017-07-29 23:15
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoMapper sellerInfoMapper;

    @Override
    public SellerInfo findSellerInfoByOpenid(Integer openid) {
        return sellerInfoMapper.findByOpenid(openid);
    }
}
