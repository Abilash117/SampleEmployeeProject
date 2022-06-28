package com.example.demo.exception;

import org.springframework.validation.BindingResult;

public class EntityValidationException extends RuntimeException {
	private BindingResult bindingResult;

	public EntityValidationException() {

	}

	public EntityValidationException(BindingResult bindingResult) {
		super();
		this.bindingResult = bindingResult;

	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

}
