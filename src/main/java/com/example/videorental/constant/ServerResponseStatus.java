package com.example.videorental.constant;

import org.springframework.http.HttpStatus;

public class ServerResponseStatus {

	
	 public final static int OK = HttpStatus.OK.value();

	    public final static int CREATED = HttpStatus.CREATED.value();

	    public final static int UPDATED = HttpStatus.ACCEPTED.value();

	    public final static int DELETED = HttpStatus.ACCEPTED.value();

	    public final static int FAILED = HttpStatus.BAD_REQUEST.value();

	    public final static int NOT_MODIFIED = HttpStatus.NOT_MODIFIED.value();

	    public final static int UNAUTHORIZED = HttpStatus.UNAUTHORIZED.value();

	    public final static int NO_CONTENT = HttpStatus.NO_CONTENT.value();
	    
	    public final static int NOT_FOUND = HttpStatus.NOT_FOUND.value();
	    
	    public final static int INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();

	    private ServerResponseStatus() {
	    }
}
