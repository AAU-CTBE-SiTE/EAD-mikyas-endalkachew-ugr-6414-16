package com.site.demo;

import com.site.demo.service.MyFirstService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(DemoApplication.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);

		myFirstService.tellAStory();
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile2());
		myFirstService.throwException();
	}
}
