package com.finrun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CtpserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtpserviceApplication.class, args);
	}
}
