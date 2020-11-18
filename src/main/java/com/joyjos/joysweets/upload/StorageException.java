package com.joyjos.joysweets.upload;

public class StorageException extends RuntimeException {
	
	private static final long serialVersionUID = 142517859250013985L;

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}

}
