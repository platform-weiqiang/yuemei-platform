package com.ym;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.ym.*.mapper")
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching(proxyTargetClass = true) // 开启缓存功能
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
