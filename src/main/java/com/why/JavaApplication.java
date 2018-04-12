package com.why;

import com.why.bean.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

//@SpringBootApplication
public class JavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);


	}

	public static final String c ="111";


	public static void a() {

		System.out.println(c);
	}


	public void b() {
		a();
		System.out.println(c);
	}


}
