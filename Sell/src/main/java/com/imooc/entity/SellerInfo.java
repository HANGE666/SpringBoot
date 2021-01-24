package com.imooc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 廖师兄
 * 2017-07-23 23:02
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private Integer sellerId;
    private String username;
    private String password;
    private String openId;
}
