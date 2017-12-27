package com.test.cahces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
// @ImportResource(value = {"classpath:cache/ehcache.xml"}) // 使用 dubbo.xml 配置；
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
