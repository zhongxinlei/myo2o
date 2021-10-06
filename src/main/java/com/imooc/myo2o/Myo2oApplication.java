package com.imooc.myo2o;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Myo2oApplication {

	public static void main(String[] args) {
		SpringApplication.run(Myo2oApplication.class, args);
	}

}
