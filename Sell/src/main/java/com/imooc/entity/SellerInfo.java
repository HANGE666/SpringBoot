package com.imooc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SellerInfo {
    @TableId
    private Integer sellerId;
    private String username;
    private String password;
    private Integer openId;
}
