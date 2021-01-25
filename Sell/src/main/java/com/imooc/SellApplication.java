package com.imooc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching // 开启开启缓存功能
@MapperScan(basePackages={"com.imooc.mapper"}) // 扫描dao文件
@SpringBootApplication(scanBasePackages = "com.imooc")
public class SellApplication {
	public static void main(String[] args) {
		SpringApplication.run(SellApplication.class, args);
	}
}
