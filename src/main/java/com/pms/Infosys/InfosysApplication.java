package com.pms.Infosys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.pms") // explicitly specify package for scanning controllers
//public class InfosysApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(InfosysApplication.class, args);
//	}
//}

//@SpringBootApplication
public class InfosysApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfosysApplication.class, args);
	}

}
