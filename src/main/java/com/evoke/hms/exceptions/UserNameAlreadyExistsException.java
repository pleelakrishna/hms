package com.evoke.hms.exceptions;

@SuppressWarnings("serial")
public class UserNameAlreadyExistsException extends Exception {

	public UserNameAlreadyExistsException(String msg){
		super(msg);
	}

	public UserNameAlreadyExistsException(String msg, Throwable t) {
		super(msg, t);
	}

}
