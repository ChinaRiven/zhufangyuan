package com.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 程序入口,相当于 web.xml
 * @author user
 *
 */
@SpringBootApplication
public class Application {

	  public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
}
