package com.imooc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ProductCategory {
    /** 类目id. */
    @TableId
    private Integer categoryId;
    /** 类目名字. */
    private String categoryName;
    /** 类目编号. */
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
    public ProductCategory() {
    }
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
