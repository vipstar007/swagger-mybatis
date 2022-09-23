package com.danni;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.danni.model.dao")
public class SpringbootMybatisSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisSwaggerApplication.class, args);
	}
}
