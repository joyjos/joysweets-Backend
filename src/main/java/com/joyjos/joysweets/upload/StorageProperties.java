package com.joyjos.joysweets.upload;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("upload")
public class StorageProperties {
	
	/**
	 * Folder location for storing files
	 */
	private String location = "uploads";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
