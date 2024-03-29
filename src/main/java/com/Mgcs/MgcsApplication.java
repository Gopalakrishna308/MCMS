package com.Mgcs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class MgcsApplication {
   final static Logger logger= LoggerFactory.getLogger("MgcsApplication.class");
	public static void main(String[] args) {
		SpringApplication.run(MgcsApplication.class, args);
		
		logger.info("------------------medical is runing---------------------");
		
	}
	 
	 
 

@Bean
public Docket productApi()
{
	return new Docket(DocumentationType.SWAGGER_2
			).select().apis(RequestHandlerSelectors.basePackage("com.Mgcs")).build();
	}}
