package com.example.demo.exception;

public class EmployeeExistsNotExistsException extends RuntimeException {
private String errorMessage ;
private int errorCode;

public int getErrorCode() {
	return errorCode;
}

public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
}

public String getErrorMessage() {
	return errorMessage;
}

public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}

public EmployeeExistsNotExistsException(String errorMessage,int errorCode) {
	super();
	this.errorMessage = errorMessage;
	this.errorCode = errorCode;
}

}
