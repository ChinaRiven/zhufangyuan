package com.file.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.file.util.Result;
import com.file.util.Strategy;


@RestController
public class Example {
		
	 @RequestMapping("/")
	    public String home() {
	
	        return Result.success("哈哈");
		 
	    }

	   
}
