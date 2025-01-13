package com.sjcframe.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/******************************************************************
 * Springboot Running 프로그램
 * @SpringBootApplication가 선언된 소스인 경우만 구동됨
 *****************************************************************/
@SpringBootApplication
public class MyspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringbootApplication.class, args);
	}

}
