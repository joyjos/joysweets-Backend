package com.joyjos.joysweets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.joyjos.joysweets.upload.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class JoysweetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoysweetsApplication.class, args);
	}

}
