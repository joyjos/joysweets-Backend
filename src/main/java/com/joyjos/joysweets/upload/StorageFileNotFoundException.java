package com.joyjos.joysweets.upload;

public class StorageFileNotFoundException extends StorageException {
	
	private static final long serialVersionUID = -7500638530608696534L;

	public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
