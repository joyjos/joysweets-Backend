package com.joyjos.joysweets.sw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/index")
	public String helloWorld(){
		return "Hello world!";
	}
}
